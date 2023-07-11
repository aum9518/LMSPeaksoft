package com.example.lmspeaksoft.dto.student.studentReq;

import com.example.lmspeaksoft.enums.StudyFormat;

import lombok.Builder;


@Builder
public record StudentRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String phoneNumber,
        StudyFormat format
) {
}
