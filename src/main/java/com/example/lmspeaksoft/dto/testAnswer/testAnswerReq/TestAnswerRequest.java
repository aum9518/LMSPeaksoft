package com.example.lmspeaksoft.dto.testAnswer.testAnswerReq;

import lombok.Builder;

@Builder
public record TestAnswerRequest(
        String nameTest,
        int correct,
        int unCorrect,
        double point,
        boolean statusTest
) {
}
