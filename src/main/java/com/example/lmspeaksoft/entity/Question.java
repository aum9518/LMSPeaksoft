package com.example.lmspeaksoft.entity;


import com.example.lmspeaksoft.enums.QuestionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "questions")
@Getter
@Setter
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(generator = "question_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "question_gen",
            sequenceName = "question_seq",
            allocationSize = 1)
    private Long id;
    private String questionName;
    @Enumerated(value = EnumType.STRING)
    private QuestionType questionType;


    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Test test;


    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH},mappedBy = "question")
    private List<OptionTest> optionTests;


    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE},mappedBy = "question")
    private List<QuestionAnswer>questionAnswers;

    public Question(Long id, String questionName, QuestionType questionType) {
        this.id = id;
        this.questionName = questionName;
        this.questionType = questionType;
    }
}
