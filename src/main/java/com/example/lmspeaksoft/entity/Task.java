package com.example.lmspeaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(generator = "task_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "task_gen",
            sequenceName = "task_seq",
            allocationSize = 1)
    private Long id;
    private String taskName;
    private String description;
    private String image;
    private String code;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Lesson lesson;


    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH},mappedBy = "task")
    private List<TaskAnswer>taskAnswers;

    public Task(Long id, String taskName, String description, String image, String code) {
        this.id = id;
        this.taskName = taskName;
        this.description = description;
        this.image = image;
        this.code = code;
    }
}
