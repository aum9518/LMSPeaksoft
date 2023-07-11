package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.test.testRes.TestResponse;

import java.util.List;

public record PaginationTestResponse(
        List<TestResponse>testResponses,
        int size,
        int page
) {
}
