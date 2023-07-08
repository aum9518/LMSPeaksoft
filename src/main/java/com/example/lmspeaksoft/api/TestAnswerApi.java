package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.service.TestAnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/testAnswers")
@RequiredArgsConstructor
public class TestAnswerApi {

    private final TestAnswerService testAnswerService;
}
