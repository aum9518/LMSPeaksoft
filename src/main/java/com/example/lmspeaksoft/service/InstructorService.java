package com.example.lmspeaksoft.service;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.instructor.instructorReq.InstructorRequest;
import com.example.lmspeaksoft.dto.instructor.instructorRes.InstructorResponse;

public interface InstructorService {
    SimpleResponse saveInstructor(InstructorRequest instructorRequest);

    InstructorResponse getInstructorById(Long id);

    SimpleResponse updateInstructor(Long id, InstructorRequest instructorRequest);

    InstructorResponse getAllInstructor();

    SimpleResponse deleteInstructorById(Long id);


}
