package com.example.lmspeaksoft.service.impl;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationStudentResponse;
import com.example.lmspeaksoft.dto.student.studentReq.StudentRequest;
import com.example.lmspeaksoft.dto.student.studentRes.StudentResponse;
import com.example.lmspeaksoft.enums.StudyFormat;
import com.example.lmspeaksoft.repository.StudentRepository;
import com.example.lmspeaksoft.repository.UserRepository;
import com.example.lmspeaksoft.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final UserRepository userRepository;
    private final JdbcTemplate jdbcTemplate;


    @Override
    public SimpleResponse saveStudent(StudentRequest studentRequest) {
//        Student student = new Student();
//        User user = new User();
//        student.setStudyFormat(studentRequest.format());
//        studentRepository.save(student);
//        user.setFirstName(studentRequest.firstName());
//        user.setLastName(studentRequest.lastName());
//        user.setEmail(studentRequest.email());
//        user.setPassword(studentRequest.password());
//        user.setPhoneNumber(studentRequest.phoneNumber());
//        userRepository.save(user);
//        return SimpleResponse
//                .builder()
//                .status(HttpStatus.OK)
//                .message("successfully saved")
//                .build();
        return null;
    }

    @Override
    public PaginationStudentResponse getAllStudent(int pageSize, int CurrentPage) {
        Pageable pageable = PageRequest.of(CurrentPage - 1, pageSize);
        Page<StudentResponse> allStudent = studentRepository.getAllStudents(pageable);
        return PaginationStudentResponse
                .builder()
                .studentResponses(allStudent.getContent())
                .page(allStudent.getNumber() + 1)
                .size(allStudent.getTotalPages())
                .build();
    }



    @Override
    public StudentResponse getById(Long id) {
//        String sql = " SELECT  s.id,u.first_name,u.last_name, s.format,u.email,u.phone_number,u.password" +
//                " FROM students s " +
//                " JOIN users u on s.user_id = u.id" +
//                " WHERE s.id = ?";
//
//         return (StudentResponse) jdbcTemplate.query(
//                        sql,
//                        new Object[]{id},
//                        (rs, rowNum) -> new StudentResponse(
//                                rs.getLong("id"),
//                                rs.getObject("format", StudyFormat.class)
//                        ));

        return null;
    }

    @Override
    public SimpleResponse updateStudent(Long id, StudentRequest studentRequest) {
        return null;
    }

    @Override
    public SimpleResponse deleteStudent(Long id) {
        return null;
    }
}
