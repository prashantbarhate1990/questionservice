package com.demo.nvQuestionBank.repository;

import org.springframework.data.repository.CrudRepository;

import com.demo.nvQuestionBank.entity.Question;

public interface QuestionsRepository extends CrudRepository<Question, Integer>{

}
