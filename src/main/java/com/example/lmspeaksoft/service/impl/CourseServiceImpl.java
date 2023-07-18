package com.example.lmspeaksoft.service.impl;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.course.courseReq.CourseRequest;
import com.example.lmspeaksoft.dto.course.courseRes.CourseResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationCourseResponse;
import com.example.lmspeaksoft.entity.Course;
import com.example.lmspeaksoft.entity.Instructor;
import com.example.lmspeaksoft.exceptions.BadRequestException;
import com.example.lmspeaksoft.exceptions.NotFoundException;
import com.example.lmspeaksoft.repository.CourseRepository;
import com.example.lmspeaksoft.repository.GroupRepository;
import com.example.lmspeaksoft.repository.InstructorRepository;
import com.example.lmspeaksoft.service.CourseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;


@Service
@Transactional
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final GroupRepository groupRepository;
    private final InstructorRepository instructorRepository;

    @Override
    public SimpleResponse saveCourse(CourseRequest courseRequest) {
        Course course = new Course();
        course.setCourseName(courseRequest.courseName());
        course.setImage(courseRequest.image());
        course.setDescription(courseRequest.description());
        course.setDate(LocalDate.now());
        course.setGroup(null);
        courseRepository.save(course);

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Course with id: " + course.getCourseName() + " is saved!"))
                .build();
    }

    @Override
    public PaginationCourseResponse getAllCourses(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<CourseResponse> allCourse = courseRepository.getAllCourse(pageable);
        return PaginationCourseResponse.builder()
                .courseResponses(allCourse.getContent())
                .page(allCourse.getNumber() + 1)
                .size(allCourse.getTotalPages())
                .build();
    }

    @Override
    public CourseResponse getById(Long id) {
        return courseRepository.findByIdCourse(id).orElseThrow(() ->
                new NotFoundException("Course with id: " + id + " is not found!"));
    }

    @Override
    public SimpleResponse updateCourse(Long id, CourseRequest courseRequest) {
        Course course = courseRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Course with id: " + id + " is not found!"));
        course.setCourseName(courseRequest.courseName());
        course.setImage(courseRequest.image());
        course.setDescription(courseRequest.description());
        course.setDate(LocalDate.now());
        courseRepository.save(course);

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Course with id: " + course.getCourseName() + " is updated!"))
                .build();
    }

    @Override
    public SimpleResponse deleteCourseById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Course with id: " + id + " is not found!"));
        course.setGroup(null);
        courseRepository.delete(course);

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Course with id: " + id + " is deleted!"))
                .build();
    }

    @Override
    public SimpleResponse assignInstructorToCourse(Long instructorId, Long courseId) {
        Instructor instructor = instructorRepository.findById(instructorId).orElseThrow(() ->
                new NotFoundException("Instructor with id: " + instructorId + " is not found!"));
        Course course = courseRepository.findById(courseId).orElseThrow(() ->
                new NotFoundException("Course with id: " + courseId + " is not found!"));

        if (instructor.getId() != null) {
            for (Instructor courseInstructor : course.getInstructors()) {
                if (Objects.equals(courseInstructor.getId(), courseId)) {
                    throw new BadRequestException("This instructor already exists!");
                }
            }
        }
        instructor.addCourse(course);
        course.addInstructor(instructor);
        instructorRepository.save(instructor);
        courseRepository.save(course);

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Instructor with id: " + instructorId + "  " + " Course with id: " + courseId + " is assigning!"))
                .build();
    }
}