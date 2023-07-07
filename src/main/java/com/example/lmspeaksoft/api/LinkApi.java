package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/links")
@RequiredArgsConstructor
public class LinkApi {

    private final LinkService linkService;
}
