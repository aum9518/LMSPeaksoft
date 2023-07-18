package com.example.lmspeaksoft.repository;

import com.example.lmspeaksoft.dto.videoLesson.videoLessonRes.VideoLessonResponse;
import com.example.lmspeaksoft.entity.VideoLesson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VideoLessonRepository extends JpaRepository<VideoLesson, Long> {

    @Query("select new com.example.lmspeaksoft.dto.videoLesson.videoLessonRes.VideoLessonResponse(v.id, v.name, v.description, v.link) from VideoLesson v where v.id=:id")
    Optional<VideoLessonResponse> getVideoLessonById(@Param("id") Long id);

    @Query("select new com.example.lmspeaksoft.dto.videoLesson.videoLessonRes.VideoLessonResponse(v.id, v.name, v.description, v.link) from VideoLesson v")
    Page<VideoLessonResponse> getAllVideoLessons(Pageable pageable);
}
