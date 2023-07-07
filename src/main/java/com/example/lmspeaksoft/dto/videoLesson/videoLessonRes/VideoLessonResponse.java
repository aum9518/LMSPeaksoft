package com.example.lmspeaksoft.dto.videoLesson.videoLessonRes;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VideoLessonResponse {
    private Long id;
    private String name;
    private String description;
    private String link;
}
