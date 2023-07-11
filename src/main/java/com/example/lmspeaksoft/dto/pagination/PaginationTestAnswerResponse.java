package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.testAnswer.testAsnwerRes.TestAnswerResponse;

import java.util.List;

public record PaginationTestAnswerResponse(
        List<TestAnswerResponse>testAnswerResponses,
        int size,
        int page
) {
}
