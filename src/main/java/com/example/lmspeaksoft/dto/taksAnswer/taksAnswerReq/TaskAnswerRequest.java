package com.example.lmspeaksoft.dto.taksAnswer.taksAnswerReq;

import lombok.Builder;

@Builder
public record TaskAnswerRequest(
        String name,
        String file,
        String text,
        String comment
) {
}
