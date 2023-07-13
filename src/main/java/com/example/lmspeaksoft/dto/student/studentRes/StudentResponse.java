package com.example.lmspeaksoft.dto.student.studentRes;

import com.example.lmspeaksoft.enums.StudyFormat;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class StudentResponse {
    private Long id;
    private String fullName;
    private String groupName;
    @Enumerated(EnumType.STRING)
    private StudyFormat studyFormat;
    private String phoneNumber;
    private String email;


    public StudentResponse(Long id, String fullName, String groupName, StudyFormat studyFormat, String phoneNumber, String email) {
        this.id = id;
        this.fullName = fullName;
        this.groupName = groupName;
        this.studyFormat = studyFormat;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

}
