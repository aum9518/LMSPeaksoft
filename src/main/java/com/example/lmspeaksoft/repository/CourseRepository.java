package com.example.lmspeaksoft.repository;

import com.example.lmspeaksoft.dto.course.courseRes.CourseResponse;
import com.example.lmspeaksoft.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("select new com.example.lmspeaksoft.dto.course.courseRes.CourseResponse(c.id, c.courseName, c.image, c.description, c.date) from Course c")
    Page<CourseResponse> getAllCourse(Pageable pageable);

    @Query("select new com.example.lmspeaksoft.dto.course.courseRes.CourseResponse(c.id, c.courseName, c.image, c.description, c.date) from Course c where c.id=:id")
    Optional<CourseResponse> findByIdCourse(@Param("id") Long id);
}
