package com.example.lmspeaksoft.service;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.authentication.AuthenticationResponse;
import com.example.lmspeaksoft.dto.authentication.EmailSend;
import com.example.lmspeaksoft.dto.authentication.RecoveryPasswordRequest;
import com.example.lmspeaksoft.dto.authentication.SignInRequest;
import java.util.Map;

public interface AuthenticationService {
    AuthenticationResponse signIn(SignInRequest signInRequest);
    SimpleResponse recoveryPassword(Long id,RecoveryPasswordRequest recoveryPasswordRequest);
    SimpleResponse sendPasswordToEmail(EmailSend emailSend);
    String createContent(String template, Map<String,String> variables);

}
