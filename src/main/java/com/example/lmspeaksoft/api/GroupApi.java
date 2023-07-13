package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.group.groupReq.GroupRequest;
import com.example.lmspeaksoft.dto.group.groupRes.GroupResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationGroupResponse;
import com.example.lmspeaksoft.dto.student.studentRes.StudentResponse;
import com.example.lmspeaksoft.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
public class GroupApi {
    private final GroupService groupService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public SimpleResponse saveGroup(@RequestBody GroupRequest groupRequest){
        return groupService.saveGroup(groupRequest);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public PaginationGroupResponse getAllGroup(int currentPage, int pageSize){
        return groupService.getAllGroup(currentPage, pageSize);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/{id}")
    public SimpleResponse updateGroup(@RequestBody GroupRequest groupRequest,@PathVariable Long id){
        return groupService.updateGroup(id, groupRequest);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public GroupResponse getAllGroupById(@PathVariable Long id){
        return groupService.getGroupById(id);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public SimpleResponse deleteGroup(@PathVariable Long id) {
        return groupService.deleteGroupById(id);

    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public List<StudentResponse> getAllStudentsGroupById(@PathVariable Long id){
        return groupService.getAllStudentsByGroupId(id);
    }
}
