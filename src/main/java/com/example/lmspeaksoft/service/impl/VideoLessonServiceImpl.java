package com.example.lmspeaksoft.service.impl;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.lesson.lessonRes.LessonResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationLessonResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationVideoLessonResponse;
import com.example.lmspeaksoft.dto.videoLesson.videoLessonReq.VideoLessonRequest;
import com.example.lmspeaksoft.dto.videoLesson.videoLessonRes.VideoLessonResponse;
import com.example.lmspeaksoft.entity.Lesson;
import com.example.lmspeaksoft.entity.VideoLesson;
import com.example.lmspeaksoft.repository.LessonRepository;
import com.example.lmspeaksoft.repository.VideoLessonRepository;
import com.example.lmspeaksoft.service.VideoService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class VideoLessonServiceImpl implements VideoService {

    private final LessonRepository lessonRepository;

    private final VideoLessonRepository videoLessonRepository;

    @Override
    public SimpleResponse saveVideoLesson(Long lessonId, VideoLessonRequest videoLessonRequest) {

        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(() ->
                new NotFoundException("Lesson with id: " + lessonId + " is not found!"));
        VideoLesson videoLesson = new VideoLesson();
        videoLesson.setName(videoLessonRequest.name());
        videoLesson.setDescription(videoLessonRequest.description());
        videoLesson.setLink(videoLessonRequest.link());
        lesson.addVideoLesson(videoLesson);
        videoLesson.setLesson(lesson);
        videoLessonRepository.save(videoLesson);

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("VideoLesson with id: " + videoLesson.getId() + " is saved!"))
                .build();
    }

    @Override
    public PaginationVideoLessonResponse getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<VideoLessonResponse> allVdLesson = videoLessonRepository.getAllVideoLessons(pageable);
        return PaginationVideoLessonResponse.builder()
                .videoLessonResponses(allVdLesson.getContent())
                .page(allVdLesson.getNumber() + 1)
                .size(allVdLesson.getTotalPages())
                .build();
    }

    @Override
    public VideoLessonResponse getByIdVideoLesson(Long id) {
        return videoLessonRepository.getVideoLessonById(id).orElseThrow(() ->
                new NotFoundException("VideoLesson with id: " + id + " is not found!"));
    }

    @Override
    public SimpleResponse updateVideoLessonById(Long id, VideoLessonRequest videoLessonRequest) {

        VideoLesson videoLesson = videoLessonRepository.findById(id).orElseThrow(() ->
                new NotFoundException("VideoLesson with id: " + id + " is not found!"));
        videoLesson.setName(videoLessonRequest.name());
        videoLesson.setDescription(videoLessonRequest.description());
        videoLesson.setLink(videoLessonRequest.link());
        videoLessonRepository.save(videoLesson);

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("VideoLesson with id: " + videoLesson.getId() + " is updated!"))
                .build();
    }

    @Override
    public SimpleResponse deleteVideoLessonById(Long id) {
        if (videoLessonRepository.existsById(id)) {
            videoLessonRepository.deleteById(id);
        } else {
            throw new NotFoundException("VideoLesson with id: " + id + " is not found!");
        }

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("VideoLesson with id: " + id + " is deleted!"))
                .build();
    }
}
