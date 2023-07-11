package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.course.courseRes.CourseResponse;

import java.util.List;

public record PaginationCourseResponse(
        List<CourseResponse> courseResponses,
        int size,
        int page
) {
}
