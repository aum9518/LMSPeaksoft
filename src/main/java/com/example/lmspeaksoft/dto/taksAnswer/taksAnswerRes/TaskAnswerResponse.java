package com.example.lmspeaksoft.dto.taksAnswer.taksAnswerRes;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskAnswerResponse {
    private Long id;
    private String name;
    private LocalDate deadline;
    private String file;
    private String text;
    private String comment;

}
