package com.example.lmspeaksoft.dto.taksAnswer.taksAnswerReq;

import com.example.lmspeaksoft.enums.TaskAnswerStatus;
import lombok.Builder;

@Builder
public record TaskAnswerRequest(
        String file,
        String text,
        String comment,
        TaskAnswerStatus taskAnswerStatus
) {
}
