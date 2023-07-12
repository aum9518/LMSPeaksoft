package com.example.lmspeaksoft.dto.task.taskRes;

import com.example.lmspeaksoft.enums.TaskData;
import lombok.*;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskResponse {
    private Long id;
    private String taskName;
    private Map<TaskData,String> data;
}
