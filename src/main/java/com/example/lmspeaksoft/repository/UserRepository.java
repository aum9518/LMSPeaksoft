package com.example.lmspeaksoft.repository;

import com.example.lmspeaksoft.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
