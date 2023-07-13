package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.instructor.instructorReq.InstructorRequest;
import com.example.lmspeaksoft.dto.instructor.instructorRes.InstructorResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationInstructorResponse;
import com.example.lmspeaksoft.service.InstructorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/instructors")
@RequiredArgsConstructor
public class InstructorApi {

    private final InstructorService instructorService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    @Operation(summary = "Get all instructors", description = "Get all instructors")
    public PaginationInstructorResponse getAllInstructors(@RequestParam int currentPage, @RequestParam int pageSize){
        return instructorService.getAllInstructor(currentPage, pageSize);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    @Operation(summary = "Save instructor", description = "Save instructor")
    public SimpleResponse saveInstructor(@RequestBody InstructorRequest instructorRequest){
        return instructorService.saveInstructor(instructorRequest);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','INSTRUCTOR')")
    @PutMapping("{id}")
    @Operation(summary = "Update instructor", description = "Update instructor")
    public SimpleResponse updateInstructor(@PathVariable Long id,@RequestBody InstructorRequest instructorRequest){
        return instructorService.updateInstructor(id, instructorRequest);
    }

    @PreAuthorize("hasAnyAuthority('ADMIN','INSTRUCTOR')")
    @GetMapping("/getById")
    @Operation(summary = "Get instructor by id", description = "Get instructor by id")
    public InstructorResponse getInstructorById(@RequestParam Long instructorId){
        return instructorService.getInstructorById(instructorId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping
    @Operation(summary = "Delete instructor ", description = "Get instructor by id")
    public SimpleResponse deleteInstructor(@RequestParam Long instructorId){
        return instructorService.deleteInstructorById(instructorId);
    }
}
