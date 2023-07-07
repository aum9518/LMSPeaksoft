package com.example.lmspeaksoft.dto.videoLesson.videoLessonReq;

import lombok.Builder;

@Builder
public record VideoLessonRequest(
        String name,
        String description,
        String link
) {
}
