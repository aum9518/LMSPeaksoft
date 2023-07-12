package com.example.lmspeaksoft.dto.group.groupRes;

import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class GroupResponse {
    private Long id;
    private String groupName;
    private String image;
    private String description;
    private LocalDate createDate;

    public GroupResponse(Long id, String groupName, String image, String description, LocalDate createDate) {
        this.id = id;
        this.groupName = groupName;
        this.image = image;
        this.description = description;
        this.createDate = createDate;
    }


}
