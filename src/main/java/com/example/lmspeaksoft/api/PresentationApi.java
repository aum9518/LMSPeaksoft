package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationPresentationResponse;
import com.example.lmspeaksoft.dto.presentation.presentationReq.PresentationRequest;
import com.example.lmspeaksoft.dto.presentation.presentationRes.PresentationResponse;
import com.example.lmspeaksoft.service.PresentationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/presentations")
@RequiredArgsConstructor
public class PresentationApi {

    private final PresentationService presentationService;

    @PreAuthorize("hasAuthority('INSTRUCTOR')")
    @PostMapping("/{lessonId}/save")
    public SimpleResponse savePresentation(@PathVariable Long lessonId, @RequestBody PresentationRequest presentationRequest) {
        return presentationService.savePresentation(lessonId, presentationRequest);
    }

    @PreAuthorize("permitAll()")
    @GetMapping
    public PaginationPresentationResponse getAll(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
                                                 @RequestParam(name = "size", required = false, defaultValue = "1") int size) {
        return presentationService.getAll(page, size);
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/{id}")
    public PresentationResponse getById(@PathVariable Long id) {
        return presentationService.getPresentationById(id);
    }

    @PreAuthorize("hasAuthority('INSTRUCTOR')")
    @PutMapping("/{id}/update")
    public SimpleResponse update(@PathVariable Long id, @RequestBody PresentationRequest presentationRequest) {
        return presentationService.updatePresentation(id, presentationRequest);
    }

    @PreAuthorize("hasAuthority('INSTRUCTOR')")
    @DeleteMapping("/{id}/delete")
    public SimpleResponse delete(@PathVariable Long id) {
        return presentationService.deletePresentationById(id);
    }
}
