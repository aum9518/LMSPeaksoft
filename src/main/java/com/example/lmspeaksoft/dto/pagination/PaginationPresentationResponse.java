package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.presentation.presentationRes.PresentationResponse;
import lombok.Builder;

import java.util.List;

@Builder
public record PaginationPresentationResponse(
        List<PresentationResponse> presentationResponses,
        int size,
        int page
) {
}
