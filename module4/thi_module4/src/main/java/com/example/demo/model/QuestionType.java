package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class QuestionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionTypeName;

    @OneToMany(mappedBy = "questionType")
    private Set<QuestionContent> questionContents;

    public QuestionType() {
    }

    public QuestionType(Long id, String questionTypeName, Set<QuestionContent> questionContents) {
        this.id = id;
        this.questionTypeName = questionTypeName;
        this.questionContents = questionContents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionTypeName() {
        return questionTypeName;
    }

    public void setQuestionTypeName(String questionTypeName) {
        this.questionTypeName = questionTypeName;
    }

    public Set<QuestionContent> getQuestionContents() {
        return questionContents;
    }

    public void setQuestionContents(Set<QuestionContent> questionContents) {
        this.questionContents = questionContents;
    }
}
