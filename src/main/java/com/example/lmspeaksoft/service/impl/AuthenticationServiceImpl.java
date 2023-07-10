package com.example.lmspeaksoft.service.impl;

import com.example.lmspeaksoft.config.JwtService;
import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.authentication.AuthenticationResponse;
import com.example.lmspeaksoft.dto.authentication.EmailSend;
import com.example.lmspeaksoft.dto.authentication.RecoveryPasswordRequest;
import com.example.lmspeaksoft.dto.authentication.SignInRequest;
import com.example.lmspeaksoft.entity.User;
import com.example.lmspeaksoft.enums.Format;
import com.example.lmspeaksoft.exceptions.BadCredentialException;
import com.example.lmspeaksoft.exceptions.BadRequestException;
import com.example.lmspeaksoft.exceptions.NotFoundException;
import com.example.lmspeaksoft.repository.UserRepository;
import com.example.lmspeaksoft.service.AuthenticationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
//@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;



    @Autowired
    public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, JavaMailSender javaMailSender) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.javaMailSender = javaMailSender;
    }

    @Override
    public AuthenticationResponse signIn(SignInRequest signInRequest) {
        User user = userRepository.getUserByEmail(signInRequest.email()).orElseThrow(() -> {
            log.error(String.format("User with this email:%s is not found", signInRequest.email()));
            throw new NotFoundException(String.format("User with this email:%s is not found", signInRequest.email()));
        });
        if (signInRequest.password().isBlank()) {
            throw new BadCredentialException("Password is blank");
        }
        if (!passwordEncoder.matches(signInRequest.password(), user.getPassword())) {
            throw new BadCredentialException("Wrong password");
        }
        String token = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(token)
                .email(user.getEmail())
                .build();

    }

    private String email = null;
    @Override
    public SimpleResponse sendPasswordToEmail(EmailSend emailSend) {
        email = emailSend.to();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromEmail);
        simpleMailMessage.setTo(emailSend.to());
        simpleMailMessage.setSubject(emailSend.subject());
        simpleMailMessage.setText(emailSend.message());
        javaMailSender.send(simpleMailMessage);
        log.info("email successfully was sent");
        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Success")
                .build();

    }
    @Override
    public SimpleResponse recoveryPassword(RecoveryPasswordRequest recoveryPasswordRequest) {
        String email1 = email;

        User user = userRepository.getUserByEmail(email1).orElseThrow(() -> {
            log.error(String.format("User with email: %s is not found.", email1));
            return new NotFoundException(String.format("User with email: %s is not found.", email1));
        });
        if (recoveryPasswordRequest.password().equals(recoveryPasswordRequest.repeatPassword())){
            user.setPassword(recoveryPasswordRequest.password());
            userRepository.save(user);
        }else {log.error("password does not match each other"); throw new BadRequestException("Password does not match each other");}

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Success")
                .build();
    }

}
