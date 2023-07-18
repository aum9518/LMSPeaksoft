package com.example.lmspeaksoft.service;


import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.link.linkReq.LinkRequest;
import com.example.lmspeaksoft.dto.link.linkRes.LinkResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationLinkResponse;

public interface LinkService {

    SimpleResponse saveLink(Long lessonId, LinkRequest linkRequest);

    PaginationLinkResponse getAllLinks(int page, int size);

    LinkResponse getLinkById(Long id);

    SimpleResponse updateLink(Long id, LinkRequest linkRequest);

    SimpleResponse deleteLinkById(Long id);
}
