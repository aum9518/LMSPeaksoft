package com.example.lmspeaksoft.dto.student.studentReq;

import com.example.lmspeaksoft.enums.Format;

import lombok.Builder;


@Builder
public record StudentRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String phoneNumber,
        Format format
) {
}
