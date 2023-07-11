package com.example.lmspeaksoft.repository;

import com.example.lmspeaksoft.dto.instructor.instructorRes.InstructorResponse;
import com.example.lmspeaksoft.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {

//    @Query("select new com.example.lmspeaksoft.dto.instructor.instructorRes.InstructorResponse(i.id,i.)from Instructor i")
//    InstructorResponse getInstructorById(Long id);
}
