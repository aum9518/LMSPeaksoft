package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.link.linkRes.LinkResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record PaginationLinkResponse(
        List<LinkResponse>linkResponses,
        int size,
        int page
) {
}
