package com.example.lmspeaksoft.dto.instructor.instructorRes;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstructorResponse {
    private Long id;
//    private Role role;
    private String occupation;
}
