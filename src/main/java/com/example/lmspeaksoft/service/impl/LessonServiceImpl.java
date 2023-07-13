package com.example.lmspeaksoft.service.impl;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.lesson.lessonReq.LessonRequest;
import com.example.lmspeaksoft.dto.lesson.lessonRes.LessonResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationLessonResponse;
import com.example.lmspeaksoft.entity.Course;
import com.example.lmspeaksoft.entity.Lesson;
import com.example.lmspeaksoft.exceptions.NotFoundException;
import com.example.lmspeaksoft.repository.CourseRepository;
import com.example.lmspeaksoft.repository.LessonRepository;
import com.example.lmspeaksoft.service.LessonService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;

    @Override
    public SimpleResponse saveLesson(Long courseId, LessonRequest lessonRequest) {
        Course course = courseRepository.findById(courseId).orElseThrow(() ->
                new NotFoundException("Course with id: " + courseId + " is not found!"));
        Lesson lesson = new Lesson();
        lesson.setLessonName(lessonRequest.lessonName());
        course.addLesson(lesson);
        lesson.setCourse(course);
        lessonRepository.save(lesson);

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Lesson with id: " + lesson.getLessonName() + " is saved!"))
                .build();
    }

    @Override
    public PaginationLessonResponse getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<LessonResponse> allLesson = lessonRepository.getAllLessons(pageable);
        return PaginationLessonResponse.builder()
                .lessonResponses(allLesson.getContent())
                .page(allLesson.getNumber() + 1)
                .size(allLesson.getTotalPages())
                .build();
    }

    @Override
    public LessonResponse getLessonById(Long id) {
        return lessonRepository.getLessonById(id).orElseThrow(() ->
                new NotFoundException("Lesson with id: " + id + " is not found!"));
    }

    @Override
    public SimpleResponse updateLesson(Long id, LessonRequest lessonRequest) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Lesson with id: " + id + " is not found!"));
        lesson.setLessonName(lessonRequest.lessonName());
        lessonRepository.save(lesson);

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Lesson with id: " + lesson.getLessonName() + " is updated!"))
                .build();
    }

    @Override
    public SimpleResponse deleteLessonById(Long id) {
        Lesson lesson = lessonRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Lesson with id: " + id + " is not found!"));
        lesson.setCourse(null);
        lessonRepository.delete(lesson);

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Lesson with id: " + id + " is deleted!"))
                .build();
    }
}
