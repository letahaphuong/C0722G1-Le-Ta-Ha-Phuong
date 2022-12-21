package com.example.demo.service.impl;


import com.example.demo.model.QuestionContent;
import com.example.demo.repository.IQuestionContentRepository;
import com.example.demo.service.IQuestionContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionContentService implements IQuestionContentService {

    @Autowired
    IQuestionContentRepository questionContentRepository;

    @Override
    public List<QuestionContent> findAll() {
        return null;
    }

    @Override
    public Optional<QuestionContent> findById(Long id) {
        return questionContentRepository.findById(id);
    }

    @Override
    public void save(QuestionContent questionContent) {
        questionContentRepository.save(questionContent);
    }

    @Override
    public Page<QuestionContent> showAll(String title,String questionType,Pageable pageable) {
        return questionContentRepository.showAll(title,questionType,pageable);
    }

    @Override
    public void removeFlag(Long id) {
        questionContentRepository.removeFlag(id);
    }
}
