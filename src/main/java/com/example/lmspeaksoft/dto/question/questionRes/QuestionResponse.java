package com.example.lmspeaksoft.dto.question.questionRes;

import com.example.lmspeaksoft.enums.QuestionType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionResponse {
    private Long id;
    private String questionName;
    private QuestionType questionType;
}
