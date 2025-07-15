package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.lesson.LessonCreateUpdateDto;
import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.model.Lesson;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface LessonService {
    Lesson createLesson(LessonCreateUpdateDto lessonCreateUpdateDto);

    Lesson getLesson(Long id);

    ArrayList<Lesson> getLessons();

    Boolean updateLesson(Long id, LessonCreateUpdateDto lessonCreateUpdateDto);

    Boolean deleteLesson(Long id);
}
