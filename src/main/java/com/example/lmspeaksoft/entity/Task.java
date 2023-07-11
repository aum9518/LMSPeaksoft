package com.example.lmspeaksoft.entity;

import com.example.lmspeaksoft.enums.TaskData;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

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
    @Lob
    private Map<TaskData,String> text;
    @Lob
    private Map<TaskData,String> file;
    @Lob
    private Map<TaskData,String> image;
    @Lob
    private Map<TaskData,String> code;
    @Lob
    private Map<TaskData,String> link;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Lesson lesson;


    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH},mappedBy = "task")
    private List<TaskAnswer>taskAnswers;

    public Task(Long id, String taskName, Map<TaskData, String> text, Map<TaskData, String> file, Map<TaskData, String> image, Map<TaskData, String> code, Map<TaskData, String> link) {
        this.id = id;
        this.taskName = taskName;
        this.text = text;
        this.file = file;
        this.image = image;
        this.code = code;
        this.link = link;
    }
}
