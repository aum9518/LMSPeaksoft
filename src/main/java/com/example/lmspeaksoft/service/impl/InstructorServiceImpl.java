package com.example.lmspeaksoft.service.impl;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.instructor.instructorReq.InstructorRequest;
import com.example.lmspeaksoft.dto.instructor.instructorRes.InstructorResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationInstructorResponse;
import com.example.lmspeaksoft.entity.Instructor;
import com.example.lmspeaksoft.entity.User;
import com.example.lmspeaksoft.enums.Role;
import com.example.lmspeaksoft.exceptions.NotFoundException;
import com.example.lmspeaksoft.repository.InstructorRepository;
import com.example.lmspeaksoft.repository.UserRepository;
import com.example.lmspeaksoft.service.InstructorService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class InstructorServiceImpl implements InstructorService {

  private final InstructorRepository instructorRepository;
  private final UserRepository userRepository;
  private final JdbcTemplate jdbcTemplate;

  @Override
  public SimpleResponse saveInstructor(InstructorRequest instructorRequest) {
    Instructor instructor = new Instructor();
    User user = new User();
    user.setFirstName(instructorRequest.firstName());
    user.setLastName(instructorRequest.lastName());
    user.setEmail(instructorRequest.email());
    user.setPassword(instructorRequest.password());
    user.setPhoneNumber(instructorRequest.phoneNumber());
    user.setRole(Role.INSTRUCTOR);
    userRepository.save(user);
    instructor.setSpecialization(instructor.getSpecialization());
    instructor.setUser(user);
    instructorRepository.save(instructor);
    return SimpleResponse
        .builder()
        .status(HttpStatus.OK)
        .message("Successfully saved!")
        .build();
  }

  @Override
  public InstructorResponse getInstructorById(Long id) {
    String query = "SELECT  u.id,concat(u.first_name, ' ', u.last_name) AS fullName,i.specialization, u.email, u.password, u.phone_number  FROM instructors i JOIN users AS u ON i.user_id = u.id WHERE i.id = ?; ";
    return jdbcTemplate.queryForObject(query,
        (rs, rowNum) -> new InstructorResponse(
            rs.getLong("id"),
            rs.getString("fullName"),
            rs.getString("specialization"),
            rs.getString("email"),
            rs.getString("password"),
            rs.getString("phone_number")
        ),id);
  }

  @Override
  public SimpleResponse updateInstructor(Long id, InstructorRequest instructorRequest) {
    Instructor instructor = instructorRepository.findById(id).orElseThrow(() -> {
      log.error(String.format("Instructor with id:%s is not found.", id));
      return new NotFoundException(String.format("Instructor with id:%s is not found.", id));
    });
    User user = userRepository.findById(instructor.getUser().getId()).orElseThrow(() -> {
      log.error(String.format("User with id:%s is not found.", instructor.getUser().getId()));
      return new NotFoundException(
          String.format("User with id:%s is not found.", instructor.getUser().getId()));
    });
    user.setFirstName(instructorRequest.firstName());
    user.setLastName(instructorRequest.lastName());
    user.setEmail(instructorRequest.email());
    user.setPassword(instructorRequest.password());
    user.setPhoneNumber(instructorRequest.phoneNumber());
    userRepository.save(user);
    instructor.setSpecialization(instructorRequest.specialization());
    instructorRepository.save(instructor);
    return SimpleResponse.builder()
        .status(HttpStatus.OK)
        .message("Successfully updated.")
        .build();
  }

  @Override
  public PaginationInstructorResponse getAllInstructor(int currentPage, int pageSize) {
    int offset = (currentPage - 1) * pageSize;
    String query = "select u.id,concat(u.first_name, ' ', u.last_name) as fullName,i.specialization, u.email, u.password, u.phone_number from instructors i join users u on i.user_id = u.id limit ? offset ?;";
    List<InstructorResponse> instructors = jdbcTemplate.query(query,
        (rs, rovNum) -> new InstructorResponse(
            rs.getLong("id"),
            rs.getString("fullName"),
            rs.getString("specialization"),
            rs.getString("email"),
            rs.getString("password"),
            rs.getString("phone_number")
        ),pageSize,offset);
    log.info("Get all instructors");
    return PaginationInstructorResponse.builder()
        .instructorResponses(instructors)
        .currentPage(currentPage)
        .pageSize(pageSize)
        .build();
  }

  @Override
  public SimpleResponse deleteInstructorById(Long id) {
      if (instructorRepository.existsById(id)) {
          instructorRepository.deleteById(id);
      } else {
          throw new NotFoundException(String.format("Instructor with id:% does not exist.", id));
      }
    log.info("Delete instructor with id: " + id);
    return SimpleResponse.builder()
        .status(HttpStatus.OK)
        .message("Deleted.")
        .build();
  }
}
