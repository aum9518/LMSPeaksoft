package com.example.lmspeaksoft.service.impl;

import static org.antlr.v4.runtime.misc.Utils.readFile;

import com.example.lmspeaksoft.config.JwtService;
import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.authentication.AuthenticationResponse;
import com.example.lmspeaksoft.dto.authentication.EmailSend;
import com.example.lmspeaksoft.dto.authentication.RecoveryPasswordRequest;
import com.example.lmspeaksoft.dto.authentication.SignInRequest;
import com.example.lmspeaksoft.entity.User;
import com.example.lmspeaksoft.exceptions.BadCredentialException;
import com.example.lmspeaksoft.exceptions.BadRequestException;
import com.example.lmspeaksoft.exceptions.NotFoundException;
import com.example.lmspeaksoft.repository.UserRepository;
import com.example.lmspeaksoft.service.AuthenticationService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final JavaMailSender javaMailSender;
    private final ResourceLoader resourceLoader;

    private static final String MAIL_TEMPLATE_BASE_NAME="mail/MailMessages";
    private static final String MAIL_TEMPLATE_PREFIX="/templates/";
    private static final String MAIL_TEMPLATE_SUFFIX=".html";
    private static final String UTF_8 = "UTF-8";
    private static TemplateEngine templateEngine;
    static {
        templateEngine = emailTemplateEngine();
    }

    private static TemplateEngine emailTemplateEngine() {
      return null;
    }

    @Value("${spring.mail.username}")
    private String fromEmail;
    private String email = null;

//    @Autowired
//    public AuthenticationServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService,
//        JavaMailSender javaMailSender) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.jwtService = jwtService;
//        this.javaMailSender = javaMailSender;
//    }

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
    private String readFile(String filePath) {
        try {
            byte[] fileBytes = Files.readAllBytes(Path.of(filePath));
            return new String(fileBytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            // Handle exception or log error
            e.printStackTrace();
        }
        return null; // Return null if file reading fails
    }

    @Override
    public SimpleResponse sendPasswordToEmail(EmailSend emailSend) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom(fromEmail);
            helper.setTo(emailSend.to());
            helper.setSubject(emailSend.subject());

            Resource resource = resourceLoader.getResource("classpath:templates/email.html");
            Path filePath = resource.getFile().toPath();
            String htmlContent = readFile(String.valueOf(filePath));
            assert htmlContent != null;
            helper.setText(htmlContent, true); // Set HTML content

            javaMailSender.send(message);
            email = emailSend.to();
            return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Success")
                .build();

        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
        @Override
    public String createContent(String template, Map<String, String> variables) {
        return null;
    }
    private String generateToken(){
       UUID uuid = UUID.randomUUID();
       return uuid.toString();
    }

    @Override
    public SimpleResponse recoveryPassword(Long id, RecoveryPasswordRequest recoveryPasswordRequest) {
        String email1 = email;
        User user = userRepository.findById(id).orElseThrow(() -> {
            log.error(String.format("User with id: %s is not found.", id));
            return new NotFoundException(String.format("User with id: %s is not found.", id));
        });
        if (recoveryPasswordRequest.password().equals(recoveryPasswordRequest.repeatPassword())) {
            user.setPassword(recoveryPasswordRequest.password());
            userRepository.save(user);
        } else {
            log.error("password does not match each other");
            throw new BadRequestException("Password does not match each other");
        }

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message("Success")
                .build();
    }

}
