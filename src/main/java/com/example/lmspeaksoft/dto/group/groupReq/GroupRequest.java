package com.example.lmspeaksoft.dto.group.groupReq;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record GroupRequest(
        String group_name,
        String image,
        String description

) {
}
