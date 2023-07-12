package com.example.lmspeaksoft.dto.user.userReq;

import com.example.lmspeaksoft.enums.Role;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record UserRequest(
        String firstName,
        String lastName,
        String email,
        String password,
        String phoneNumber
) {
}
