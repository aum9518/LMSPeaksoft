package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseApi {

    private final CourseService courseService;

}
