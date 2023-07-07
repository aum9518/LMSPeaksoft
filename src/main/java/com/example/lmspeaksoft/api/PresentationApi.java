package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.service.PresentationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/presentations")
@RequiredArgsConstructor
public class PresentationApi {

    private final PresentationService presentationService;
}
