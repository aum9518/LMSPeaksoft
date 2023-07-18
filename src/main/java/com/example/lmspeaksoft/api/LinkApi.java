package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.link.linkReq.LinkRequest;
import com.example.lmspeaksoft.dto.link.linkRes.LinkResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationLinkResponse;
import com.example.lmspeaksoft.service.LinkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/links")
@RequiredArgsConstructor
public class LinkApi {

    private final LinkService linkService;

    @PreAuthorize("hasAuthority('INSTRUCTOR')")
    @PostMapping("/{lessonId}/save")
    public SimpleResponse save(@PathVariable Long lessonId, @RequestBody @Valid LinkRequest linkRequest) {
        return linkService.saveLink(lessonId, linkRequest);
    }

    @PreAuthorize("permitAll()")
    @GetMapping
    public PaginationLinkResponse getAll(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
                                           @RequestParam(name = "size", required = false, defaultValue = "1") int size) {
        return linkService.getAllLinks(page, size);
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/{id}")
    public LinkResponse getById(@PathVariable Long id) {
        return linkService.getLinkById(id);
    }

    @PreAuthorize("hasAuthority('INSTRUCTOR')")
    @PutMapping("/{id}/update")
    public SimpleResponse update(@PathVariable Long id, @RequestBody LinkRequest linkRequest) {
        return linkService.updateLink(id, linkRequest);
    }

    @PreAuthorize("hasAuthority('INSTRUCTOR')")
    @DeleteMapping("/{id}/delete")
    public SimpleResponse delete(@PathVariable Long id) {
        return linkService.deleteLinkById(id);
    }

}
