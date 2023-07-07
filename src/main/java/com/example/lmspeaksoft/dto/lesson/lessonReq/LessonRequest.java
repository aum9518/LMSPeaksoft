package com.example.lmspeaksoft.dto.lesson.lessonReq;

import lombok.Builder;

@Builder
public record LessonRequest(
        String lessonName
) {
}
