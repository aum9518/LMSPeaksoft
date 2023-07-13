package com.example.lmspeaksoft.repository;

import com.example.lmspeaksoft.dto.lesson.lessonRes.LessonResponse;
import com.example.lmspeaksoft.entity.Lesson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LessonRepository extends JpaRepository<Lesson, Long> {

    @Query("select new com.example.lmspeaksoft.dto.lesson.lessonRes.LessonResponse(l.id, l.lessonName) from Lesson l")
    Page<LessonResponse> getAllLessons(Pageable pageable);

    @Query("select new com.example.lmspeaksoft.dto.lesson.lessonRes.LessonResponse(l.id, l.lessonName) from Lesson l where l.id=:id")
    Optional<LessonResponse> getLessonById(@Param("id") Long id);
}
