package com.example.lmspeaksoft.dto.task.taskReq;

import com.example.lmspeaksoft.enums.TaskData;
import lombok.Builder;

import java.util.Map;

@Builder
public record TaskRequest(
        String taskName,
        Map<TaskData,String> data
) {
}
