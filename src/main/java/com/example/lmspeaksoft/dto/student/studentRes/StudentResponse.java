package com.example.lmspeaksoft.dto.student.studentRes;

import com.example.lmspeaksoft.enums.StudyFormat;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class StudentResponse {
    private Long id;
    private StudyFormat studyFormat;

    public StudentResponse(Long id, StudyFormat studyFormat) {
        this.id = id;
        this.studyFormat = studyFormat;
    }
}
