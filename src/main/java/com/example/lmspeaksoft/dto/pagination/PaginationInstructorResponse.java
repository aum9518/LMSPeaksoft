package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.instructor.instructorRes.InstructorResponse;
import lombok.Builder;

import java.util.List;
@Builder
public record PaginationInstructorResponse(
        List<InstructorResponse> instructorResponses,
        int currentPage,
        int pageSize
) {
}
