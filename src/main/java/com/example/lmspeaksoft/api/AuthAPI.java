package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.authentication.AuthenticationResponse;
import com.example.lmspeaksoft.dto.authentication.EmailSend;
import com.example.lmspeaksoft.dto.authentication.RecoveryPasswordRequest;
import com.example.lmspeaksoft.dto.authentication.SignInRequest;
import com.example.lmspeaksoft.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthAPI {
    private final AuthenticationService authenticationService;

    @PostMapping("/signIn")
    @Operation(summary = "Sign in", description = "sign in")
    public AuthenticationResponse signIn(@RequestBody SignInRequest signInRequest){
       return authenticationService.signIn(signInRequest);
    }

    @PostMapping("/sendEmail")
    @Operation(summary = "Send email", description = "Send email")
    public SimpleResponse sendEmail(@RequestBody EmailSend emailSend){
        return authenticationService.sendPasswordToEmail(emailSend);
    }

    @PostMapping("/recover-password/{studentId}")
    @Operation(summary = "recovery password", description = "recovery password")
    public SimpleResponse recoverPassword(@PathVariable Long studentId,@RequestBody RecoveryPasswordRequest recoveryPasswordRequest){
        return authenticationService.recoveryPassword(studentId, recoveryPasswordRequest);
    }
}
