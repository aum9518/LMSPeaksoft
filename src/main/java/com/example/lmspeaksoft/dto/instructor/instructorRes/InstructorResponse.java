package com.example.lmspeaksoft.dto.instructor.instructorRes;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class InstructorResponse {
    private Long id;
    private String fullName;
    private String specialization;
    private String email;
    private String password;
    private String phoneNumber;

    public InstructorResponse(Long id, String fullName, String specialization, String email, String password, String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        this.specialization = specialization;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }



}
