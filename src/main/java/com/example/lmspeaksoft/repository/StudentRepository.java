package com.example.lmspeaksoft.repository;

import com.example.lmspeaksoft.dto.student.studentRes.StudentResponse;
import com.example.lmspeaksoft.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select new com.example.lmspeaksoft.dto.student.studentRes.StudentResponse(s.id,s.studyFormat) from Student  s join s.user ")
    Page<StudentResponse> getAllStudents(Pageable pageable);
}
