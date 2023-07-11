package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.task.taskRes.TaskResponse;

import java.util.List;

public record PaginationTaskResponse(
        List<TaskResponse>taskResponses,
        int size,
        int page
) {
}
