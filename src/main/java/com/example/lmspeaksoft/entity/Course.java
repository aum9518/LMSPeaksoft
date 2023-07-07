package com.example.lmspeaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(generator = "course_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course_gen",
            sequenceName = "course_seq",
            allocationSize = 1)
    private Long id;
    private String courseName;
    private String image;
    private String description;
    private LocalDate duration;
    private LocalDate date;




    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Instructor instructor;


    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH},mappedBy = "course")
    private List<Lesson> lessons;

    public Course(Long id, String courseName, String image, String description, LocalDate duration, LocalDate date) {
        this.id = id;
        this.courseName = courseName;
        this.image = image;
        this.description = description;
        this.duration = duration;
        this.date = date;
    }
}
