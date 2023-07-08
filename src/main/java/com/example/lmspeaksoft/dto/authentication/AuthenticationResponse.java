package com.example.lmspeaksoft.dto.authentication;

import lombok.Builder;

@Builder
public record AuthenticationResponse(String token,
                                     String email) {
    public AuthenticationResponse {
    }
}
