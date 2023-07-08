package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/videoLessons")
@RequiredArgsConstructor
public class VideoLessonApi {

    private final VideoService videoService;
}
