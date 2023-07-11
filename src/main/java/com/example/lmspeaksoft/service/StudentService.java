package com.example.lmspeaksoft.service;


import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationStudentResponse;
import com.example.lmspeaksoft.dto.student.studentReq.StudentRequest;
import com.example.lmspeaksoft.dto.student.studentRes.StudentResponse;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    SimpleResponse saveStudent(StudentRequest studentRequest);

    PaginationStudentResponse getAllStudent(int pageSize, int CurrentPage);

    StudentResponse getById(Long id);

    SimpleResponse updateStudent(Long id,StudentRequest studentRequest);

    SimpleResponse deleteStudent (Long id);
}
