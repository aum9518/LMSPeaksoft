package com.example.lmspeaksoft.dto.instructor.instructorRes;

import com.example.lmspeaksoft.enums.Role;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstructorResponse {
    private Long id;
    private String specialization;
}
