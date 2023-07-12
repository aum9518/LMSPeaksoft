package com.example.lmspeaksoft.dto.user.userRes;

import com.example.lmspeaksoft.enums.Role;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private Role role;

}
