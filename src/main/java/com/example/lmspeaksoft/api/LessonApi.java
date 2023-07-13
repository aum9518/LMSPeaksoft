package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.lesson.lessonReq.LessonRequest;
import com.example.lmspeaksoft.dto.lesson.lessonRes.LessonResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationLessonResponse;
import com.example.lmspeaksoft.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonApi {

    private final LessonService lessonService;

    @PreAuthorize("hasAuthority('INSTRUCTOR')")
    @PostMapping("/{courseId}/save")
    public SimpleResponse saveLesson(@PathVariable Long courseId, @RequestBody LessonRequest lessonRequest) {
        return lessonService.saveLesson(courseId, lessonRequest);
    }

    @PreAuthorize("permitAll()")
    @GetMapping
    public PaginationLessonResponse getAll(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
                                           @RequestParam(name = "size", required = false, defaultValue = "1") int size) {
        return lessonService.getAll(page, size);
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/{id}")
    public LessonResponse getById(@PathVariable Long id) {
        return lessonService.getLessonById(id);
    }

    @PreAuthorize("hasAuthority('INSTRUCTOR')")
    @PutMapping("/{id}/update")
    public SimpleResponse update(@PathVariable Long id, @RequestBody LessonRequest lessonRequest) {
        return lessonService.updateLesson(id, lessonRequest);
    }

    @PreAuthorize("hasAuthority('INSTRUCTOR')")
    @DeleteMapping("/{id}/delete")
    public SimpleResponse delete(@PathVariable Long id) {
        return lessonService.deleteLessonById(id);
    }
}
