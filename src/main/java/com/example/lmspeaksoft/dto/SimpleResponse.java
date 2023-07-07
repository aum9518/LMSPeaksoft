package com.example.lmspeaksoft.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SimpleResponse {
    private HttpStatus status;
    private String message;
}
