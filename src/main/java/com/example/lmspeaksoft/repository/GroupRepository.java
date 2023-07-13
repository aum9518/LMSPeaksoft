package com.example.lmspeaksoft.repository;

import com.example.lmspeaksoft.dto.group.groupRes.GroupResponse;
import com.example.lmspeaksoft.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("SELECT NEW com.example.lmspeaksoft.dto.group.groupRes.GroupResponse(g.id,g.groupName,g.image,g.description,g.createDate)from Group g")
    Page<GroupResponse> getAllGroup(Pageable pageable);
}
