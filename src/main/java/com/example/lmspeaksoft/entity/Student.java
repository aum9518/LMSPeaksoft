package com.example.lmspeaksoft.entity;


import com.example.lmspeaksoft.enums.Format;
import com.example.lmspeaksoft.enums.Role;
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
    private Role role;
    private Format format;


    @ManyToOne(cascade = {CascadeType.MERGE,
            CascadeType.DETACH,
            CascadeType.REFRESH})
    private Group group;

    @OneToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private User user;

    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH},mappedBy = "student")
    private List<TaskAnswer> taskAnswers;

    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH},mappedBy = "student")
    private List<Test>tests;
    public Student(Long id, Role role, Format format) {
        this.id = id;
        this.role = role;
        this.format = format;
    }
}
