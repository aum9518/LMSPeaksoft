package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tests")
@RequiredArgsConstructor
public class TestApi {

    private final TestService testService;
}
