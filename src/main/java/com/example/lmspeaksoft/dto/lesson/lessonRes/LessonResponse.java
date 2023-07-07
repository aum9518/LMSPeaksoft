package com.example.lmspeaksoft.dto.lesson.lessonRes;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LessonResponse {
    private Long id;
    private String lessonName;

}
