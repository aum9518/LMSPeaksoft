package com.example.lmspeaksoft.dto.task.taskReq;

import lombok.Builder;

@Builder
public record TaskRequest(
        String taskName,
        String description,
        String image,
        String code
) {
}
