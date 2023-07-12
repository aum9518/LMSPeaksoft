package com.example.lmspeaksoft.entity;

import com.example.lmspeaksoft.enums.TaskData;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

import static java.awt.SystemColor.text;

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
    @ElementCollection
    @Enumerated(value = EnumType.STRING)
    private Map<TaskData,String> data;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Lesson lesson;


    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH},mappedBy = "task")
    private List<TaskAnswer>taskAnswers;

    public Task(Long id, String taskName, Map<TaskData, String> data) {
        this.id = id;
        this.taskName = taskName;
        this.data = data;

    }
}
