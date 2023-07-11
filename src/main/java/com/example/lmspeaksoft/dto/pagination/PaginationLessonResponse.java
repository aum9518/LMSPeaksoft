package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.lesson.lessonRes.LessonResponse;

import java.util.List;

public record PaginationLessonResponse(
        List<LessonResponse>lessonResponses,
        int size,
        int page
) {
}
