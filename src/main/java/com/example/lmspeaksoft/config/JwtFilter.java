package com.example.lmspeaksoft.config;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.lmspeaksoft.entity.User;
import com.example.lmspeaksoft.exceptions.NotFoundException;
import com.example.lmspeaksoft.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain) throws ServletException, IOException {
        final String tokenHeader = request.getHeader("Authorization");
        if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
            String token = tokenHeader.substring(7);
            if (StringUtils.hasText(token)) {
                try {
                    String userName = jwtService.validateToken(token);
                    User user = userRepository.getUserByEmail(userName).orElseThrow(() -> new NotFoundException(String.format("User with email:%s does not exist", userName)));
                    SecurityContextHolder.getContext()
                            .setAuthentication(
                                    new UsernamePasswordAuthenticationToken(
                                            user.getUsername()
                                            , null,
                                            user.getAuthorities()
                                    )
                            );
                } catch (JWTVerificationException e) {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid token");
                }
            }
        }
        filterChain.doFilter(request, response);
    }

}

