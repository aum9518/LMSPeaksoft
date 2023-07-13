package com.example.lmspeaksoft.repository;

import com.example.lmspeaksoft.dto.group.groupRes.GroupResponse;
import com.example.lmspeaksoft.dto.student.studentRes.StudentResponse;
import com.example.lmspeaksoft.entity.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("SELECT NEW com.example.lmspeaksoft.dto.group.groupRes.GroupResponse(g.id,g.groupName,g.image,g.description,g.createDate)from Group g")
    Page<GroupResponse> getAllGroup(Pageable pageable);


    @Query("select new com.example.lmspeaksoft.dto.student.studentRes.StudentResponse(" +
            "s.id, " +
            "concat(s.user.firstName,' ',s.user.lastName), " +
            "s.group.groupName, " +
            "s.studyFormat, " +
            "s.user.phoneNumber, " +
            "s.user.email) " +
            "from Student s where s.group.id = :id")
    List<StudentResponse> getAllStudentsByGroupId(@Param("id")Long id);


}
