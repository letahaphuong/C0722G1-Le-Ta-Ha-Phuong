package com.example.demo.service;

import com.example.demo.model.QuestionContent;
import com.example.demo.model.QuestionType;

import java.util.List;

public interface IQuestionTypeService {
    List<QuestionType> findAll();

}
