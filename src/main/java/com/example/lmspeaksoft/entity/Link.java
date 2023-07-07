package com.example.lmspeaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "links")
@Getter
@Setter
@NoArgsConstructor
public class Link {
    @Id
    @GeneratedValue(generator = "link_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "link_gen",
            sequenceName = "link_seq",
            allocationSize = 1)
    private Long id;
    private String text;
    private String link;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Lesson lesson;

    public Link(Long id, String text, String link) {
        this.id = id;
        this.text = text;
        this.link = link;
    }
}
