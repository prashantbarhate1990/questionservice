package com.demo.nvQuestionBank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.nvQuestionBank.entity.Question;
import com.demo.nvQuestionBank.repository.QuestionsRepository;


@Service
public class QuestionBankService {

	@Autowired 
	QuestionsRepository repository;
	
	public List<Question> getAllQuestions() {
		List<Question> questions = new ArrayList<Question>();  
		repository.findAll().forEach(que -> questions.add(que));  
		return questions; 
	}
	
	public Optional<Question> getQuestionById(int id) {
		return repository.findById(id);
		
	}

	public void saveQuestion(Question question) {
		repository.save(question);
	}
	
	
}
