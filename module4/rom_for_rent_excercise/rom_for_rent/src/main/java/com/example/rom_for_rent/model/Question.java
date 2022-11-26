package com.example.rom_for_rent.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "mcq_question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JoinColumn (name = "questionId")
    private Long questionId;

    @Column(nullable = false)
    private String question;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable( name = "Answer", joinColumns = @JoinColumn ( name = "question_id"), inverseJoinColumns = @JoinColumn( name = "option_id"))
    private List<Option> options;

    @OneToMany(mappedBy = "questionId", cascade = CascadeType.ALL)
    private Set<Option> option;
}