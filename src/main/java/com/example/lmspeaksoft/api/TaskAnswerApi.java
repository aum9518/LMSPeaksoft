package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.entity.TaskAnswer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/taskAnswers")
@RequiredArgsConstructor
public class TaskAnswerApi {

    private final TaskAnswer taskAnswer;
}
