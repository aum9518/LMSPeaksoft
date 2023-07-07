package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonApi {

    private final LessonService lessonService;
}
