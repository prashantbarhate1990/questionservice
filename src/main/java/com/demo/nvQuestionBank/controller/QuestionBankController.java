package com.demo.nvQuestionBank.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.demo.nvQuestionBank.entity.Question;
import com.demo.nvQuestionBank.service.QuestionBankService;

import io.micrometer.core.instrument.util.StringUtils;


@RestController
@RequestMapping("/nvquestionbank.com")
public class QuestionBankController {

	@Autowired 
	QuestionBankService service;
	
	Logger logger = LogManager.getLogger(QuestionBankController.class);
	
	@GetMapping("/questions")  
	private ResponseEntity<List<Question>> getAllQuestions()   
	{  
		logger.info("Inside method getAllQuestions");
		List<Question> questions = service.getAllQuestions();
		logger.info("All questions returned from DB");
		return new ResponseEntity<>(questions, HttpStatus.OK);
	}

	
	@PostMapping("/addQuestion")
	private ResponseEntity<String> saveQuestion(@RequestBody  Question question)
	{
		String res = "Your question has been created";
		service.saveQuestion(question);
		logger.info("Question has been created");
		return new ResponseEntity<>(res, HttpStatus.CREATED);		
	}
	
	@PostMapping("/updateQuestion")
	private ResponseEntity<String> updateQuestion(@RequestBody  Question question)
	{
		String res = "Your question has been updated. Please check it";
		Optional<Question> que;
		try {
			que = service.getQuestionById(question.getId());
		} catch (Exception e) {
			res = "Record is not present for given ID";
			return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
		}
		if (que.isEmpty() ) {
			res = "Record is not present for given ID";
			return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
		}
		//update description only if its not empty
		//que.setQuestion(question.getQuestion());
		//if(StringUtils.isNotEmpty(question.getDescription()))
		//	que.setDescription(question.getDescription());
		service.saveQuestion(question);
		logger.info("Question has been updated");
		return new ResponseEntity<>(res, HttpStatus.OK);		 	
	}
}
