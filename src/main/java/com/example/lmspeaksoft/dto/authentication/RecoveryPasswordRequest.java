package com.example.lmspeaksoft.dto.authentication;

import lombok.Builder;

@Builder
public record RecoveryPasswordRequest(String password,String repeatPassword) {
    public RecoveryPasswordRequest {
    }
}
