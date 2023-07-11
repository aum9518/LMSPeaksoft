package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.videoLesson.videoLessonRes.VideoLessonResponse;

import java.util.List;

public record PaginationVideoLessonResponse(
        List<VideoLessonResponse> videoLessonResponses,
        int size,
        int page
) {
}
