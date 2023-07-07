package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/instructors")
@RequiredArgsConstructor
public class InstructorApi {

    private final InstructorService instructorService;
}
