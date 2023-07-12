package com.example.lmspeaksoft.dto.user.userRes;

import com.example.lmspeaksoft.enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseToken {
    private String token;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

}
