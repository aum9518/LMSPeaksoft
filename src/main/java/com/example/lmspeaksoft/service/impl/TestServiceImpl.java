package com.example.lmspeaksoft.service.impl;

import com.example.lmspeaksoft.service.TestService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {
}
