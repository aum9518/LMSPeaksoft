package com.example.lmspeaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private int unCorrect;
    private double point;
    private boolean statusTest;


    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Test test;
    

    public TestAnswer(Long id, String testName, int correct, int unCorrect, double point, boolean statusTest) {
        this.id = id;
        this.testName = testName;
        this.correct = correct;
        this.unCorrect = unCorrect;
        this.point = point;
        this.statusTest = statusTest;
    }
}
