package com.example.lmspeaksoft.repository;

import com.example.lmspeaksoft.dto.link.linkRes.LinkResponse;
import com.example.lmspeaksoft.entity.Link;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LinkRepository extends JpaRepository<Link, Long> {

    @Query("select new com.example.lmspeaksoft.dto.link.linkRes.LinkResponse(l.id, l.text, l.link) from Link l")
    Page<LinkResponse> getAllLink(Pageable pageable);

    @Query("select new com.example.lmspeaksoft.dto.link.linkRes.LinkResponse(l.id, l.text, l.link) from Link l where  l.id=:id")
    Optional<LinkResponse> getLessonById(@Param("id") Long id);
}
