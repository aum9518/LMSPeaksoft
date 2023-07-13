package com.example.lmspeaksoft.service.impl;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationPresentationResponse;
import com.example.lmspeaksoft.dto.presentation.presentationReq.PresentationRequest;
import com.example.lmspeaksoft.dto.presentation.presentationRes.PresentationResponse;
import com.example.lmspeaksoft.entity.Lesson;
import com.example.lmspeaksoft.entity.Presentation;
import com.example.lmspeaksoft.exceptions.NotFoundException;
import com.example.lmspeaksoft.repository.LessonRepository;
import com.example.lmspeaksoft.repository.PresentationRepository;
import com.example.lmspeaksoft.service.PresentationService;
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
public class PresentationServiceImpl implements PresentationService {

    private final PresentationRepository presentationRepository;
    private final LessonRepository lessonRepository;

    @Override
    public SimpleResponse savePresentation(Long lessonId, PresentationRequest presentationRequest) {
        Lesson lesson = lessonRepository.findById(lessonId).orElseThrow(() ->
                new NotFoundException("Lesson with id: " + lessonId + " is not found!"));
        Presentation presentation =  new Presentation();
        presentation.setName(presentationRequest.name());
        presentation.setDescription(presentationRequest.description());
        presentation.setFormat(presentationRequest.format());

        lesson.addPresentation(presentation);
        presentation.setLesson(lesson);
        presentationRepository.save(presentation);

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Presentation with id: " + presentation.getName() + " is saved!"))
                .build();
    }

    @Override
    public PaginationPresentationResponse getAll(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<PresentationResponse> allPresentation = presentationRepository.getAllPresentation(pageable);
        return PaginationPresentationResponse.builder()
                .presentationResponses(allPresentation.getContent())
                .page(allPresentation.getNumber() + 1)
                .size(allPresentation.getTotalPages())
                .build();
    }

    @Override
    public PresentationResponse getPresentationById(Long id) {
        return presentationRepository.getPresentationById(id).orElseThrow(() ->
                new NotFoundException("Presentation with id: " + id + " is not found!"));
    }

    @Override
    public SimpleResponse updatePresentation(Long id, PresentationRequest presentationRequest) {
        Presentation presentation = presentationRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Presentation with id: " + id + " is not found!"));
        presentation.setName(presentationRequest.name());
        presentation.setDescription(presentationRequest.description());
        presentation.setFormat(presentationRequest.format());
        presentationRepository.save(presentation);

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Presentation with id: " + presentation.getName() + " is updated!"))
                .build();
    }

    @Override
    public SimpleResponse deletePresentationById(Long id) {
        Presentation presentation = presentationRepository.findById(id).orElseThrow(() ->
                new NotFoundException("Presentation with id: " + id + " is not found!"));
        presentation.setLesson(null);
        presentationRepository.delete(presentation);

        return SimpleResponse.builder()
                .status(HttpStatus.OK)
                .message(String.format("Presentation with id: " + presentation.getName() + " is deleted!"))
                .build();
    }


}
