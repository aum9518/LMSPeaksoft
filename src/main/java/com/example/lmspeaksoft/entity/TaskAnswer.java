package com.example.lmspeaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "task_answers")
@Getter
@Setter
@NoArgsConstructor
public class TaskAnswer {
    @Id
    @GeneratedValue(generator = "taskAnswer_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "taskAnswer_gen",
            sequenceName = "taskAnswer_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private LocalDate deadline;
    private String file;
    private String text;
    private String comment;


    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Student student;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Task task;

    public TaskAnswer(Long id, String name, LocalDate deadline, String file, String text, String comment) {
        this.id = id;
        this.name = name;
        this.deadline = deadline;
        this.file = file;
        this.text = text;
        this.comment = comment;
    }
}
