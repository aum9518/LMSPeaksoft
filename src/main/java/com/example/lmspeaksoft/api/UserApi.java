package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserApi {

    private final UserService userService;
}
