package com.example.lmspeaksoft.api;

import com.example.lmspeaksoft.dto.SimpleResponse;
import com.example.lmspeaksoft.dto.pagination.PaginationVideoLessonResponse;
import com.example.lmspeaksoft.dto.videoLesson.videoLessonReq.VideoLessonRequest;
import com.example.lmspeaksoft.dto.videoLesson.videoLessonRes.VideoLessonResponse;
import com.example.lmspeaksoft.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/videoLessons")
@RequiredArgsConstructor
public class VideoLessonApi {

    private final VideoService videoService;

    @PreAuthorize("hasAuthority('INSTRUCTOR')")
    @PostMapping("/{lessonId}/save")
    public SimpleResponse save(@PathVariable Long lessonId, @RequestBody VideoLessonRequest videoLessonRequest) {
        return videoService.saveVideoLesson(lessonId, videoLessonRequest);

    }

    @PreAuthorize("permitAll()")
    @GetMapping
    public PaginationVideoLessonResponse getAll(@RequestParam(name = "page", required = false, defaultValue = "1") int page,
                                                @RequestParam(name = "size", required = false, defaultValue = "1") int size) {
        return videoService.getAll(page, size);
    }

    @PreAuthorize("permitAll()")
    @GetMapping("/{id}")
    public VideoLessonResponse getById(@PathVariable Long id) {
        return videoService.getByIdVideoLesson(id);
    }

    @PreAuthorize("hasAuthority('INSTRUCTOR')")
    @PutMapping("/{id}/update")
    public SimpleResponse update(@PathVariable Long id, @RequestBody VideoLessonRequest videoLessonRequest) {
        return videoService.updateVideoLessonById(id, videoLessonRequest);

    }

    @PreAuthorize("hasAuthority('INSTRUCTOR')")
    @DeleteMapping("/{id}/delete")
    public SimpleResponse deleteById(@PathVariable Long id) {
        return videoService.deleteVideoLessonById(id);
    }
}
