package com.example.lmspeaksoft.service.impl;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.link.linkReq.LinkRequest;
import com.example.lmspeaksoft.dto.link.linkRes.LinkResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationLinkResponse;
import com.example.lmspeaksoft.entity.Lesson;
import com.example.lmspeaksoft.entity.Link;
import com.example.lmspeaksoft.exceptions.NotFoundException;
import com.example.lmspeaksoft.repository.LessonRepository;
import com.example.lmspeaksoft.repository.LinkRepository;
import com.example.lmspeaksoft.service.LinkService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;
    private final LessonRepository lessonRepository;

    @Override
    public SimpleResponse saveLink(Long lessonId, LinkRequest linkRequest) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(() ->
                new NotFoundException("Lesson with id: " + lessonId + " is not found!"));

        Link link = new Link();
        link.setText(linkRequest.text());
        link.setLink(linkRequest.link());
        lesson.addLink(link);
        link.setLesson(lesson);
        linkRepository.save(link);

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Link with id: " + link.getId() + " is saved!"))
                .build();
    }

    @Override
    public PaginationLinkResponse getAllLinks(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<LinkResponse> allLesson = linkRepository.getAllLink(pageable);
        return PaginationLinkResponse.builder()
                .linkResponses(allLesson.getContent())
                .page(allLesson.getNumber() + 1)
                .size(allLesson.getTotalPages())
                .build();
    }

    @Override
    public LinkResponse getLinkById(Long id) {
        return linkRepository.getLessonById(id).orElseThrow(() ->
                new NotFoundException("Link with id: " + id + " is not found!"));
    }

    @Override
    public SimpleResponse updateLink(Long id, LinkRequest linkRequest) {
        Link link = linkRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Link with id: " + id + " is not found!"));
        link.setText(linkRequest.text());
        link.setLink(linkRequest.link());
        linkRepository.save(link);

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Link with id: " + id + " is updated!"))
                .build();
    }

    @Override
    public SimpleResponse deleteLinkById(Long id) {
        Link link = linkRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Link with id: " + id + " is not found!"));
        link.setLesson(null);
        linkRepository.delete(link);

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Link with id: " + id + " is deleted!"))
                .build();
    }
}
