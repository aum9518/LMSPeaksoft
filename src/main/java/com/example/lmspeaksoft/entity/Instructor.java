package com.example.lmspeaksoft.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "instructors")
@Getter
@Setter
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(generator = "instructor_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "instructor_gen",
            sequenceName = "instructor_seq",
            allocationSize = 1)
    private Long id;
    private String occupation;


    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH},mappedBy = "instructor")
   private List<Course>courses;

    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH},mappedBy = "instructor")
    private List<Group>groups;

    public Instructor(Long id, String occupation) {
        this.id = id;
        this.occupation = occupation;
    }
}
