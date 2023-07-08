package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskApi {

    private final TaskService taskService;
}
