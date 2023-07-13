package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.course.courseReq.CourseRequest;
import com.example.lmspeaksoft.dto.course.courseRes.CourseResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationCourseResponse;
import com.example.lmspeaksoft.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseApi {

    private final CourseService courseService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/{id}/save")
    public SimpleResponse save(@PathVariable Long id, @RequestBody CourseRequest courseRequest) {
        return courseService.saveCourse(id, courseRequest);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'INSTRUCTOR', 'STUDENT')")
    @GetMapping
    public PaginationCourseResponse getAll(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
                                           @RequestParam(name = "size", required = false, defaultValue = "1") int size) {
        return courseService.getAllCourses(page, size);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'INSTRUCTOR', 'STUDENT')")
    @GetMapping("/{id}")
    public CourseResponse getById(@PathVariable Long id) {
        return courseService.getById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}/update")
    public SimpleResponse update(@PathVariable Long id, @RequestBody CourseRequest courseRequest) {
        return courseService.updateCourse(id, courseRequest);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}/delete")
    public SimpleResponse delete(@PathVariable Long id) {
        return courseService.deleteCourseById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/{instructorId}/{courseId}/assign")
    public SimpleResponse assign(@PathVariable Long instructorId, @PathVariable Long courseId) {
        return courseService.assignInstructorToCourse(instructorId, courseId);
    }
}
