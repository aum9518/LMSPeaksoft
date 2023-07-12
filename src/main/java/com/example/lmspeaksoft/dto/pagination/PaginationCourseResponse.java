package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.course.courseRes.CourseResponse;
import lombok.Builder;

import java.util.List;
@Builder
public record PaginationCourseResponse(
        List<CourseResponse> courseResponses,
        int size,
        int page
) {
}
