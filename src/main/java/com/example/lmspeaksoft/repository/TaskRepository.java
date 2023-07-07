package com.example.lmspeaksoft.repository;

import com.example.lmspeaksoft.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
