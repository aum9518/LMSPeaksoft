package com.example.lmspeaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "test_answers")
@Getter
@Setter
@NoArgsConstructor
public class TestAnswer {
    @Id
    @GeneratedValue(generator = "testAnswer_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "testAnswer_gen",
            sequenceName = "testAnswer_seq",
            allocationSize = 1)
    private Long id;
    private String testName;
    private int correct;
    private int inCorrect;
    private double point;
    private boolean isAccepted;


    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Test test;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Student student;
    @OneToMany(mappedBy = "testAnswer",cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private List<QuestionAnswer> questionAnswers;



    public TestAnswer(Long id, String testName, int correct, int inCorrect, double point, boolean isAccepted) {
        this.id = id;
        this.testName = testName;
        this.correct = correct;
        this.inCorrect = inCorrect;
        this.point = point;
        this.isAccepted = isAccepted;
    }
}
