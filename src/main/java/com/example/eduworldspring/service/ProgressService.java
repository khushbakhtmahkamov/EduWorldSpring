package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.progress.ProgressCreateUpdateDto;
import com.example.eduworldspring.dto.progress.ProgressDto;
import java.util.List;

public interface ProgressService {
    ProgressDto createProgress(ProgressCreateUpdateDto dto);
    ProgressDto getProgressById(Long id);
    List<ProgressDto> getAllProgress();
    List<ProgressDto> getProgressByUserId(Long userId);
    List<ProgressDto> getProgressBySubjectId(Long subjectId);
    ProgressDto updateProgress(Long id, ProgressCreateUpdateDto dto);
    void deleteProgress(Long id);
}