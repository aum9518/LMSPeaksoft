package com.example.lmspeaksoft.dto.group.groupRes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GroupResponse {
    private String groupName;
    private String image;
    private String description;
    private LocalDate createDate;

}
