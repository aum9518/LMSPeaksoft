package com.example.lmspeaksoft.service;


import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationVideoLessonResponse;
import com.example.lmspeaksoft.dto.videoLesson.videoLessonReq.VideoLessonRequest;
import com.example.lmspeaksoft.dto.videoLesson.videoLessonRes.VideoLessonResponse;

public interface VideoService {

    SimpleResponse saveVideoLesson(Long lessonId, VideoLessonRequest videoLessonRequest);

    PaginationVideoLessonResponse getAll(int page, int size);

    VideoLessonResponse getByIdVideoLesson(Long id);

    SimpleResponse updateVideoLessonById(Long id, VideoLessonRequest videoLessonRequest);

    SimpleResponse deleteVideoLessonById(Long id);

}
