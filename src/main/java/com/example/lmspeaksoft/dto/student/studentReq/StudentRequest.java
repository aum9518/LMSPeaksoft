package com.example.lmspeaksoft.dto.student.studentReq;

import com.example.lmspeaksoft.enums.StudyFormat;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;


@Builder
public record StudentRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String phoneNumber,
        @Enumerated(EnumType.STRING)
        StudyFormat studyFormat
) {
}
