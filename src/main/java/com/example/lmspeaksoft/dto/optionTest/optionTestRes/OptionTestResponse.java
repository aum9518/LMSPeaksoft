package com.example.lmspeaksoft.dto.optionTest.optionTestRes;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OptionTestResponse {
    private Long id;
    private String option;
    private Boolean statusOption;
}
