package com.example.lmspeaksoft.repository;

import com.example.lmspeaksoft.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
