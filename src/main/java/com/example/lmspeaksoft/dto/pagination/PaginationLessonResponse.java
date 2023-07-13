package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.lesson.lessonRes.LessonResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record PaginationLessonResponse(
        List<LessonResponse>lessonResponses,
        int size,
        int page
) {
}
