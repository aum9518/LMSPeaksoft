package com.example.lmspeaksoft.dto.student.studentRes;

import com.example.lmspeaksoft.enums.Format;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class StudentResponse {
    private Long id;
    private Format format;

    public StudentResponse(Long id, Format format) {
        this.id = id;
        this.format = format;
    }
}
