package com.example.lmspeaksoft.service.impl;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.instructor.instructorReq.InstructorRequest;
import com.example.lmspeaksoft.dto.instructor.instructorRes.InstructorResponse;
import com.example.lmspeaksoft.entity.Instructor;
import com.example.lmspeaksoft.repository.InstructorRepository;
import com.example.lmspeaksoft.service.InstructorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;

    @Override
    public SimpleResponse saveInstructor(InstructorRequest instructorRequest) {
        Instructor instructor = new Instructor();
        instructor.setSpecialization(instructor.getSpecialization());
        instructorRepository.save(instructor);
        return SimpleResponse
                .builder()
                .status(HttpStatus.OK)
                .message("Successfully saved!")
                .build();
    }

    @Override
    public InstructorResponse getInstructorById(Long id) {
        return null;
    }

    @Override
    public SimpleResponse updateInstructor(Long id, InstructorRequest instructorRequest) {
        return null;
    }

    @Override
    public InstructorResponse getAllInstructor() {
        return null;
    }

    @Override
    public SimpleResponse deleteInstructorById(Long id) {
        return null;
    }
}
