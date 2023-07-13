package com.example.lmspeaksoft.service;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationPresentationResponse;
import com.example.lmspeaksoft.dto.presentation.presentationReq.PresentationRequest;
import com.example.lmspeaksoft.dto.presentation.presentationRes.PresentationResponse;

public interface PresentationService {

    SimpleResponse savePresentation(Long lessonId, PresentationRequest presentationRequest);

    PaginationPresentationResponse getAll(int page, int size);

    PresentationResponse getPresentationById(Long id);

    SimpleResponse updatePresentation(Long id, PresentationRequest presentationRequest);

    SimpleResponse deletePresentationById(Long id);
}
