package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.taksAnswer.taksAnswerRes.TaskAnswerResponse;

import java.util.List;

public record PaginationTaskAnswerResponse(
        List<TaskAnswerResponse>taskAnswerResponses,
        int size,
        int page
) {
}
