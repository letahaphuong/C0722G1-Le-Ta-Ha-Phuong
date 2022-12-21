package com.example.demo.service;

import com.example.demo.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IQuestionContentService {
    List<QuestionContent> findAll();

    Optional<QuestionContent> findById(Long id);

    void save(QuestionContent questionContent);

    Page<QuestionContent> showAll(String title,String questionType,Pageable pageable);

    void removeFlag(Long id);
}
