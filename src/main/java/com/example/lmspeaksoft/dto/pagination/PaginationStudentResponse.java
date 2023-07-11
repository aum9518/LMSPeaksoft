package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.student.studentRes.StudentResponse;
import lombok.Builder;

import java.util.List;
@Builder
public record PaginationStudentResponse(
        List<StudentResponse>studentResponses,
        int size,
        int page
) {
}
