package com.example.lmspeaksoft.dto.testAnswer.testAsnwerRes;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestAnswerResponse {
    private Long id;
    private String testName;
    private int correct;
    private int inCorrect;
    private double point;
    private boolean isAccepted;
}
