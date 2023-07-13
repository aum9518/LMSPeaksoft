package com.example.lmspeaksoft.dto.group.groupRes;

import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GroupResponse {
    private Long id;
    private String group_name;
    private String image;
    private String description;
    private LocalDate create_date;




}
