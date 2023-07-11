package com.example.lmspeaksoft.dto.optionTest.optionTestReq;

import lombok.Builder;

@Builder
public record OptionTestRequest(
        String option,
        Boolean isTrue
) {
}
