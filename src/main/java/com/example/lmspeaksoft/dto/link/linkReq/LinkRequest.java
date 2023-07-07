package com.example.lmspeaksoft.dto.link.linkReq;

import lombok.Builder;

@Builder
public record LinkRequest(
        String text,
        String link
) {
}
