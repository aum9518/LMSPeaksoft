package com.example.lmspeaksoft.service;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.lesson.lessonReq.LessonRequest;
import com.example.lmspeaksoft.dto.lesson.lessonRes.LessonResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationLessonResponse;

public interface LessonService {

    SimpleResponse saveLesson(Long courseId, LessonRequest lessonRequest);

    PaginationLessonResponse getAll(int page, int size);

    LessonResponse getLessonById(Long id);

    SimpleResponse updateLesson(Long id, LessonRequest lessonRequest);

    SimpleResponse deleteLessonById(Long id);
}
