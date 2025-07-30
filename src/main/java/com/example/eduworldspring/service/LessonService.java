package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.lesson.LessonCreateUpdateDto;
import com.example.eduworldspring.dto.lesson.LessonDto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LessonService {
    LessonDto createLesson(LessonCreateUpdateDto lessonCreateUpdateDto);

    LessonDto getLesson(Long id);

    List<LessonDto> getLessons();

    void updateLesson(Long id, LessonCreateUpdateDto lessonCreateUpdateDto);

    void deleteLesson(Long id);
}
