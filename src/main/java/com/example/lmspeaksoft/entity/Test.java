package com.example.lmspeaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tests")
@Getter
@Setter
@NoArgsConstructor
public class Test {
    @Id
    @GeneratedValue(generator = "test_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "test_gen",
            sequenceName = "test_seq",
            allocationSize = 1)
    private Long id;
    private String name;


    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Student student;


    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Lesson lesson;


    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH},mappedBy = "test")
    private List<TestAnswer>testAnswers;


    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH},mappedBy = "test")
    private List<Question>questions;

    public Test(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
