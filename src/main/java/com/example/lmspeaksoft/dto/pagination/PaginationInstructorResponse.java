package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.instructor.instructorRes.InstructorResponse;

import java.util.List;

public record PaginationInstructorResponse(
        List<InstructorResponse>instructorResponses,
        int size,
        int page
) {
}
