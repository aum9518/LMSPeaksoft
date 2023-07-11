package com.example.lmspeaksoft.dto.instructor.instructorReq;

import com.example.lmspeaksoft.enums.Role;
import lombok.Builder;

@Builder
public record InstructorRequest (
        String specialization
){
}
