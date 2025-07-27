package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.progress.ProgressDto;
import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.mapper.ProgressMapper;
import com.example.eduworldspring.dto.progress.ProgressCreateUpdateDto;
import com.example.eduworldspring.model.*;
import com.example.eduworldspring.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgressServiceImpl implements ProgressService {
    private final ProgressRepository progressRepository;
    private final ProgressMapper progressMapper;
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;

    @Override
    @Transactional
    public ProgressDto createProgress(ProgressCreateUpdateDto dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new BusinessRuntimeException(
                        BusinessExceptionCode.NOT_FOUND,
                        "User not found with ID: " + dto.getUserId()));

        Subject subject = subjectRepository.findById(dto.getSubjectId())
                .orElseThrow(() -> new BusinessRuntimeException(
                        BusinessExceptionCode.NOT_FOUND,
                        "Subject not found with ID: " + dto.getSubjectId()));


        Progress progress = progressMapper.toEntity(dto);
        progress.setUser(user);
        progress.setSubject(subject);

        if (progress.getAttendance() == null) {
            progress.setAttendance(0.0);
        }
        if (progress.getTotalLesson() == null) {
            progress.setTotalLesson(0);
        }
        if (progress.getCompletedLessons() == null) {
            progress.setCompletedLessons(0);
        }

        Progress savedProgress = progressRepository.save(progress);
        return progressMapper.toDto(savedProgress);
    }

    @Override
    @Transactional(readOnly = true)
    public ProgressDto getProgressById(Long id) {
        return progressMapper.toDto(progressRepository.findById(id)
                .orElseThrow(() -> new BusinessRuntimeException(
                        BusinessExceptionCode.NOT_FOUND,
                        "Progress record not found with ID: " + id)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProgressDto> getAllProgress() {
        return progressRepository.findAll().stream()
                .map(progressMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProgressDto> getProgressByUserId(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.NOT_FOUND,
                    "User not found with ID: " + userId);
        }
        return progressRepository.findAllByUserId(userId).stream()
                .map(progressMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProgressDto> getProgressBySubjectId(Long subjectId) {
        if (!subjectRepository.existsById(subjectId)) {
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.NOT_FOUND,
                    "Subject not found with ID: " + subjectId);
        }
        return progressRepository.findAllBySubjectId(subjectId).stream()
                .map(progressMapper::toDto)
                .toList();
    }

    @Override
    @Transactional
    public ProgressDto updateProgress(Long id, ProgressCreateUpdateDto dto) {
        Progress progress = progressRepository.findById(id)
                .orElseThrow(() -> new BusinessRuntimeException(
                        BusinessExceptionCode.NOT_FOUND,
                        "Progress record not found with ID: " + id));

        if (dto.getAvgGrade() != null) {
            progress.setAvgGrade(dto.getAvgGrade());
        }
        if (dto.getAttendance() != null) {
            progress.setAttendance(dto.getAttendance());
        }
        if (dto.getCompletedLessons() != null) {
            if (dto.getCompletedLessons() < 0) {
                throw new BusinessRuntimeException(
                        BusinessExceptionCode.BAD_REQUEST,
                        "Completed lessons cannot be negative");
            }
            progress.setCompletedLessons(dto.getCompletedLessons());
        }
        if (dto.getTotalLesson() != null) {
            if (dto.getTotalLesson() < 0) {
                throw new BusinessRuntimeException(
                        BusinessExceptionCode.BAD_REQUEST,
                        "Total lessons cannot be negative");
            }
            progress.setTotalLesson(dto.getTotalLesson());
        }

        // Проверяем, что completedLessons не превышает totalLesson
        if (progress.getCompletedLessons() > progress.getTotalLesson()) {
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.BAD_REQUEST,
                    "Completed lessons cannot exceed total lessons");
        }

        Progress updatedProgress = progressRepository.save(progress);
        return progressMapper.toDto(updatedProgress);
    }

    @Override
    @Transactional
    public void deleteProgress(Long id) {
        if (!progressRepository.existsById(id)) {
            throw new BusinessRuntimeException(
                    BusinessExceptionCode.NOT_FOUND,
                    "Progress record not found with ID: " + id);
        }
        progressRepository.deleteById(id);
    }
}