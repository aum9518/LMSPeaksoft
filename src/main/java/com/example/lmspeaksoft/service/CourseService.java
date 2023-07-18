package com.example.lmspeaksoft.service;


import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.course.courseReq.CourseRequest;
import com.example.lmspeaksoft.dto.course.courseRes.CourseResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationCourseResponse;

public interface CourseService {

    SimpleResponse saveCourse(CourseRequest courseRequest);

    PaginationCourseResponse getAllCourses(int page, int size);

    CourseResponse getById(Long id);

    SimpleResponse updateCourse(Long id, CourseRequest courseRequest);

    SimpleResponse deleteCourseById(Long id);

    SimpleResponse assignInstructorToCourse(Long instructorId, Long courseId);


}
