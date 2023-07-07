package com.example.lmspeaksoft.repository;

import com.example.lmspeaksoft.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
