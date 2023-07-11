package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.optionTest.optionTestRes.OptionTestResponse;

import java.util.List;

public record PaginationOptionResponse(
        List<OptionTestResponse>optionTestResponses,
        int size,
        int page
) {
}
