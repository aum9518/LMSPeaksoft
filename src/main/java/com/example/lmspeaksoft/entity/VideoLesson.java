package com.example.lmspeaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "video_lessons")
@Getter
@Setter
@NoArgsConstructor
public class VideoLesson {
    @Id
    @GeneratedValue(generator = "videoLesson_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "videoLesson_gen",
            sequenceName = "videoLesson_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private String description;
    private String link;


    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Lesson lesson;

    public VideoLesson(Long id, String name, String description, String link) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.link = link;
    }
}
