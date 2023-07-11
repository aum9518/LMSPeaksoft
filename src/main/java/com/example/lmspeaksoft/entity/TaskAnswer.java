package com.example.lmspeaksoft.entity;

import com.example.lmspeaksoft.enums.TaskAnswerStatus;
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
    private String file;
    private String text;
    private String comment;
    private TaskAnswerStatus taskAnswerStatus;



    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Student student;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Task task;


    public TaskAnswer(Long id, String file, String text, String comment, TaskAnswerStatus taskAnswerStatus) {
        this.id = id;
        this.file = file;
        this.text = text;
        this.comment = comment;
        this.taskAnswerStatus = taskAnswerStatus;
    }
}
