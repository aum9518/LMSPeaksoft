package com.example.lmspeaksoft.dto.taksAnswer.taksAnswerRes;

import com.example.lmspeaksoft.enums.TaskAnswerStatus;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskAnswerResponse {
    private Long id;
    private String file;
    private String text;
    private String comment;
    private TaskAnswerStatus taskAnswerStatus;


}
