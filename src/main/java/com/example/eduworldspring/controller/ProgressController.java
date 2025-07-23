package com.example.eduworldspring.controller;

import com.example.eduworldspring.dto.progress.ProgressCreateUpdateDto;
import com.example.eduworldspring.dto.progress.ProgressDto;
import com.example.eduworldspring.service.ProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progress")
@RequiredArgsConstructor
public class ProgressController {
    private final ProgressService progressService;

    @PostMapping
    public ProgressDto createProgress(@RequestBody ProgressCreateUpdateDto dto) {
        return progressService.createProgress(dto);
    }

    @GetMapping("/{id}")
    public ProgressDto getProgress(@PathVariable Long id) {
        return progressService.getProgressById(id);
    }

    @GetMapping
    public List<ProgressDto> getAllProgress() {
        return progressService.getAllProgress();
    }

    @GetMapping("/user/{userId}")
    public List<ProgressDto> getProgressByUser(@PathVariable Long userId) {
        return progressService.getProgressByUserId(userId);
    }

    @GetMapping("/subject/{subjectId}")
    public List<ProgressDto> getProgressBySubject(@PathVariable Long subjectId) {
        return progressService.getProgressBySubjectId(subjectId);
    }

    @PutMapping("/{id}")
    public ProgressDto updateProgress(@PathVariable Long id, @RequestBody ProgressCreateUpdateDto dto) {
        return progressService.updateProgress(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteProgress(@PathVariable Long id) {
        progressService.deleteProgress(id);
    }
}