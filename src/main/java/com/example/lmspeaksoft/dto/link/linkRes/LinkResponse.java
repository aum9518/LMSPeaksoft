package com.example.lmspeaksoft.dto.link.linkRes;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LinkResponse {
    private Long id;
    private String text;
    private String link;
}
