package com.example.lmspeaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "presentations")
@Getter
@Setter
@NoArgsConstructor
public class Presentation {
    @Id
    @GeneratedValue(generator = "presentation_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "presentation_gen",
            sequenceName = "presentation_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private String description;
    private String format;


    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH})
    private Lesson lesson;

    public Presentation(Long id, String name, String description, String format) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.format = format;
    }
}
