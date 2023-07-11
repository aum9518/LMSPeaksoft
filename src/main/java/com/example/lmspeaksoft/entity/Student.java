package com.example.lmspeaksoft.entity;


import com.example.lmspeaksoft.enums.StudyFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(generator = "student_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student_gen",
            sequenceName = "student_seq",
            allocationSize = 1)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private StudyFormat studyFormat;


    @ManyToOne(cascade = {CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH})
    private Group group;


    @OneToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE})
    private User user;


    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH},mappedBy = "student")
    private List<TaskAnswer> taskAnswers;


    @OneToMany(mappedBy = "student",cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE})
    private List<TestAnswer>testAnswers;



    public Student(Long id, StudyFormat studyFormat) {
        this.id = id;
        this.studyFormat = studyFormat;
    }
}
