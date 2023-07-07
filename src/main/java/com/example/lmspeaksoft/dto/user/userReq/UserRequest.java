package com.example.lmspeaksoft.dto.user.userReq;

import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserRequest(
        String firstName,
        String lastName,
        LocalDate dateOfBirth,
        String email,
        String password,
        String phoneNumber
) {
}
