package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.group.groupRes.GroupResponse;

import java.util.List;

public record PaginationGroupResponse(
        List<GroupResponse>groupResponses,
        int size,
        int page
) {
}
