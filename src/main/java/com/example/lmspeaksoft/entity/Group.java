package com.example.lmspeaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
public class Group {
    @Id
    @GeneratedValue(generator = "group_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "group_gen",
            sequenceName = "group_seq",
            allocationSize = 1)
    private Long id;
    private String groupName;
    private String image;
    private String description;
    private LocalDate createDate;


    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH},mappedBy = "group")
    private List<Student> students;

    @OneToMany(mappedBy = "group",cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private List<Course>courses;



    public Group(Long id, String groupName, String image, String description, LocalDate createDate) {
        this.id = id;
        this.groupName = groupName;
        this.image = image;
        this.description = description;
        this.createDate = createDate;
    }
}
