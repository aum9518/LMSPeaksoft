package com.example.lmspeaksoft.dto.question.questionRes;

import com.example.lmspeaksoft.enums.QuestionType;
import lombok.*;

@Getter
@Setter
@Builder
public class QuestionResponse {
    private String questionName;
    private QuestionType questionType;
}
