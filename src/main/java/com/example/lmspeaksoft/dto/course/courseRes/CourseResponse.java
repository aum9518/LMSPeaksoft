package com.example.lmspeaksoft.dto.course.courseRes;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseResponse {
    private Long id;
    private String courseName;
    private String image;
    private String description;
    private LocalDate date;
}
