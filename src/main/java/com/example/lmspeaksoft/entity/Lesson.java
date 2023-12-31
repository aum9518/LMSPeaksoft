package com.example.lmspeaksoft.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "lessons")
@Getter
@Setter
@NoArgsConstructor
public class Lesson {
    @Id
    @GeneratedValue(generator = "lesson_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "lesson_gen",
            sequenceName = "lesson_seq",
            allocationSize = 1)
    private Long id;
    private String lessonName;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Course course;

    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH}, mappedBy = "lesson")
    private List<Task> tasks;

    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH}, mappedBy = "lesson")
    private List<Test> tests;


    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH}, mappedBy = "lesson")
    private List<VideoLesson> videoLessons;


    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH}, mappedBy = "lesson")
    private List<Link> links;


    @OneToMany(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH}, mappedBy = "lesson")
    private List<Presentation> presentations;

    public Lesson(Long id, String lessonName) {
        this.id = id;
        this.lessonName = lessonName;
    }

    public void addPresentation(Presentation presentation) {
        if (presentations == null) {
            presentations = new ArrayList<>();
        }
        presentations.add(presentation);
    }

    public void addLink(Link link) {
        if (links == null) {
            links = new ArrayList<>();
        }
        links.add(link);
    }

    public void addVideoLesson(VideoLesson videoLesson) {
        if (videoLessons == null) {
            videoLessons = new ArrayList<>();
        }
        videoLessons.add(videoLesson);
    }
}
