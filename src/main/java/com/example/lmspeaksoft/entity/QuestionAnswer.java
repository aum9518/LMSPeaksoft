package com.example.lmspeaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "questionAnswers")
@Getter
@Setter
@NoArgsConstructor
public class QuestionAnswer {
    @Id
    @GeneratedValue(generator = "question_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "question_gen",
            sequenceName = "question_seq",
            allocationSize = 1)
    private Long id;
    private double point;

    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private List<OptionTest> option;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,})
    private Question question;
}
