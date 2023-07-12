package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.group.groupRes.GroupResponse;
import lombok.Builder;

import java.util.List;
@Builder
public record PaginationGroupResponse(
        List<GroupResponse>groupResponses,
        int currentPage,
        int pageSize
) {
}
