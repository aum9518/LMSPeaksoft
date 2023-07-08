package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionApi {

    private final QuestionService questionService;
}
