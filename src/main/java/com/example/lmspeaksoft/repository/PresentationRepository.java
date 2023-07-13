package com.example.lmspeaksoft.repository;

import com.example.lmspeaksoft.dto.presentation.presentationRes.PresentationResponse;
import com.example.lmspeaksoft.entity.Presentation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PresentationRepository extends JpaRepository<Presentation, Long> {

   @Query("select new com.example.lmspeaksoft.dto.presentation.presentationRes.PresentationResponse(p.id, p.name, p.description, p.format) from Presentation p where p.id=:id")
   Optional<PresentationResponse> getPresentationById(@Param("id") Long id);

   @Query("select new com.example.lmspeaksoft.dto.presentation.presentationRes.PresentationResponse(p.id, p.name, p.description, p.format) from Presentation p")
   Page<PresentationResponse> getAllPresentation(Pageable pageable);
}
