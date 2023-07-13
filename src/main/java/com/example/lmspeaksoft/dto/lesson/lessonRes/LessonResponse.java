package com.example.lmspeaksoft.dto.lesson.lessonRes;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class LessonResponse {
    private Long id;
    private String lessonName;

    public LessonResponse(Long id, String lessonName) {
        this.id = id;
        this.lessonName = lessonName;
    }
}
