package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupApi {

    private final GroupService groupService;
}
