package com.example.lmspeaksoft.dto.course.courseReq;

import lombok.Builder;


@Builder
public record CourseRequest(
        String courseName,
        String image,
        String description
) {
}
