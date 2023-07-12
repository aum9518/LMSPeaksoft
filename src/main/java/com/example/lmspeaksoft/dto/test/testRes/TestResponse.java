package com.example.lmspeaksoft.dto.test.testRes;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TestResponse {
    private Long id;
    private String name;
    private boolean isEnable;
}
