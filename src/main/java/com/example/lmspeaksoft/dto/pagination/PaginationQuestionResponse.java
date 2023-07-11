package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.question.questionRes.QuestionResponse;

import java.util.List;

public record PaginationQuestionResponse (
        List<QuestionResponse>questionResponses,
        int size,
        int page
){
}
