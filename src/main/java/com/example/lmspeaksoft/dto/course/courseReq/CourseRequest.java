package com.example.lmspeaksoft.dto.course.courseReq;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record CourseRequest(
        String courseName,
        String image,
        String description,
        LocalDate date
) {
}
