package com.example.lmspeaksoft.service;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.group.groupReq.GroupRequest;
import com.example.lmspeaksoft.dto.group.groupRes.GroupResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationGroupResponse;
import com.example.lmspeaksoft.dto.student.studentRes.StudentResponse;

import java.util.List;

public interface GroupService {
    SimpleResponse saveGroup(GroupRequest groupRequest);

    PaginationGroupResponse getAllGroup(int currentPage, int pageSize);

    SimpleResponse updateGroup(Long id, GroupRequest groupRequest);

    GroupResponse getGroupById(Long id);

    SimpleResponse deleteGroupById(Long id);

    List<StudentResponse> getAllStudentsByGroupId(Long id);

}
