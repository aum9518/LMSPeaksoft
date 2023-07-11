package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.presentation.presentationRes.PresentationResponse;

import java.util.List;

public record PaginationPresentationResponse(
        List<PresentationResponse> presentationResponses,
        int size,
        int page
) {
}
