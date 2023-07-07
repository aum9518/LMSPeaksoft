package com.example.lmspeaksoft.entity;


import com.example.lmspeaksoft.enums.Role;
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
    private Role role;
    private String ocupation;


    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH},mappedBy = "instructor")
   private List<Course>courses;

    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH},mappedBy = "instructor")
    private List<Group>groups;

    public Instructor(Long id, Role role, String ocupation) {
        this.id = id;
        this.role = role;
        this.ocupation = ocupation;
    }
}
