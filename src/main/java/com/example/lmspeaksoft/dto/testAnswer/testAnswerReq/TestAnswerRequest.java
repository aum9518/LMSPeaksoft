package com.example.lmspeaksoft.dto.testAnswer.testAnswerReq;

import lombok.Builder;

@Builder
public record TestAnswerRequest(
        String testName,
        int correct,
        int unCorrect,
        double point,
        boolean isAccepted
) {
}
