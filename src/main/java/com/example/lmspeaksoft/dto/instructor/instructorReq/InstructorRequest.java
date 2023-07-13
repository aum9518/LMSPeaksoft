package com.example.lmspeaksoft.dto.instructor.instructorReq;

import com.example.lmspeaksoft.enums.Role;
import lombok.Builder;

@Builder
public record InstructorRequest (
        String firstName,
        String lastName,
        String email,
        String password,
        String phoneNumber,
        String specialization
){
}
