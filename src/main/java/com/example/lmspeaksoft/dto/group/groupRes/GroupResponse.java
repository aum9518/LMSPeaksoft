package com.example.lmspeaksoft.dto.group.groupRes;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GroupResponse {
    private String groupName;
    private String image;
    private String description;
    private LocalDate createDate;

}
