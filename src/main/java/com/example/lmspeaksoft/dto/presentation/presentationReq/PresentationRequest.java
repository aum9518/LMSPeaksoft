package com.example.lmspeaksoft.dto.presentation.presentationReq;

import lombok.Builder;

@Builder
public record PresentationRequest(
        String name,
        String description,
        String format
) {
}
