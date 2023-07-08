package com.example.lmspeaksoft.dto.authentication;

import lombok.Builder;

@Builder
public record SignInRequest(String email,
                            String password) {
    public SignInRequest {
    }
}
