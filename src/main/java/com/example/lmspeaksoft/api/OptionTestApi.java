package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.service.OptionTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/optionTexts")
@RequiredArgsConstructor
public class OptionTestApi {

    private final OptionTestService optionTestService;
}
