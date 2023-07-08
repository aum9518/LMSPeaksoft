package com.example.lmspeaksoft.dto.authentication;

import lombok.Builder;

@Builder
public record EmailSend(String to,String subject,String message) {
    public EmailSend {
    }
}
