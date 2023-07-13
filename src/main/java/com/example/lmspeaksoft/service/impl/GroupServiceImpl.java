package com.example.lmspeaksoft.service.impl;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.group.groupReq.GroupRequest;
import com.example.lmspeaksoft.dto.group.groupRes.GroupResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationGroupResponse;
import com.example.lmspeaksoft.entity.Group;
import com.example.lmspeaksoft.exceptions.NotFoundException;
import com.example.lmspeaksoft.repository.GroupRepository;
import com.example.lmspeaksoft.service.GroupService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public SimpleResponse saveGroup(GroupRequest groupRequest) {
        Group group = new Group();
        group.setGroupName(groupRequest.group_name());
        group.setImage(groupRequest.image());
        group.setDescription(groupRequest.description());
        group.setCreateDate(LocalDate.now());
        groupRepository.save(group);
        return SimpleResponse
                .builder()
                .status(HttpStatus.OK)
                .message("Successfully save!")
                .build();
    }

    @Override
    public PaginationGroupResponse getAllGroup(int currentPage, int pageSize) {
        Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        Page<GroupResponse> allGroup = groupRepository.getAllGroup(pageable);
        return PaginationGroupResponse.builder()
                .groupResponses(allGroup.getContent())
                .currentPage(allGroup.getNumber() + 1)
                .pageSize(allGroup.getTotalPages())
                .build();
    }

    @Override
    public SimpleResponse updateGroup(Long id, GroupRequest groupRequest) {
        Group group = groupRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Group with id: " + id + "not found"));
        group.setGroupName(groupRequest.group_name());
        group.setImage(groupRequest.image());
        group.setDescription(groupRequest.description());
        group.setCreateDate(LocalDate.now());
        groupRepository.save(group);
        return SimpleResponse
                .builder()
                .status(HttpStatus.OK)
                .message("Successfully Updated!")
                .build();
    }

    @Override
    public GroupResponse getGroupById(Long id) {
            String sql = "select g.id, g.group_name, g.image, g.description, g.create_Date from groups g where g.id = ?";

        List<GroupResponse> query = jdbcTemplate.query(
                sql,
                new Object[]{id},
                (rs, rowNum) -> new GroupResponse(
                        rs.getLong("id"),
                        rs.getString("group_name"),
                        rs.getString("image"),
                        rs.getString("description"),
                        rs.getDate("create_Date").toLocalDate()
                )
        );
        return query.isEmpty() ? null : query.get(0);
    }

    @Override
    public SimpleResponse deleteGroupById(Long id) {
        Group group = groupRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Group with id: " + id + "not found"));
        groupRepository.delete(group);
        return SimpleResponse
                .builder()
                .status(HttpStatus.OK)
                .message("Delete Group..")
                .build();
    }
}
