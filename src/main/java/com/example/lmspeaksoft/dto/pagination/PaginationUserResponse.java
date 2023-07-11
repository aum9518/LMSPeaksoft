package com.example.lmspeaksoft.dto.pagination;

import com.example.lmspeaksoft.dto.user.userRes.UserResponse;

import java.util.List;

public record PaginationUserResponse(
        List<UserResponse> userResponses,
        int size,
        int page
) {
}
