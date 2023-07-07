package com.example.lmspeaksoft.dto.presentation.presentationRes;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PresentationResponse {
    private Long id;
    private String name;
    private String description;
    private String format;
}
