package com.example.lmspeaksoft.dto.student.studentRes;

import com.example.lmspeaksoft.enums.StudyFormat;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class StudentResponse {
    private Long id;
    private StudyFormat format;

    public StudentResponse(Long id, StudyFormat format) {
        this.id = id;
        this.format = format;
    }
}
