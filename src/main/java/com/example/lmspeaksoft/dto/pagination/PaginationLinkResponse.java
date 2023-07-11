package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.link.linkRes.LinkResponse;

import java.util.List;

public record PaginationLinkResponse(
        List<LinkResponse>linkResponses,
        int size,
        int page
) {
}
