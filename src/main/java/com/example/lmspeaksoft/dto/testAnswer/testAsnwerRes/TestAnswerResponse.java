package com.example.lmspeaksoft.dto.testAnswer.testAsnwerRes;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestAnswerResponse {
    private Long id;
    private String nameTest;
    private int correct;
    private int unCorrect;
    private double point;
    private boolean statusTest;
}
