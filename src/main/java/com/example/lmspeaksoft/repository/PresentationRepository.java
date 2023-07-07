package com.example.lmspeaksoft.repository;

import com.example.lmspeaksoft.entity.Presentation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresentationRepository extends JpaRepository<Presentation, Long> {
}
