package com.example.lmspeaksoft.dto.question.questionReq;

import com.example.lmspeaksoft.enums.QuestionType;
import lombok.Builder;

@Builder
public record QuestionRequest(
        String questionName,
        QuestionType questionType
) {
}
