package com.example.eduworldspring.service;

import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.dto.lesson.LessonCreateUpdateDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public class LessonServiceImpl implements LessonService{
    private ArrayList<Lesson> lessons = new ArrayList<>();
    @Override
    public Lesson createLesson(LessonCreateUpdateDto lessonCreateUpdateDto) {
        return null;
    }

    @Override
    public Lesson getLesson(Long id) {
        if (id == null) {
            return null;
        }
        for (Lesson lesson : lessons) {
            if (lesson.getLesson_id().equals(id)) {
                return lesson;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    @Override
    public Boolean updateLesson(LessonCreateUpdateDto lessonCreateUpdateDto, Long id) {
        if (id == null || lessonCreateUpdateDto == null) {
            return false;
        }
        return false;
    }

    @Override
    public Boolean deleteLesson(Long id) {
        if (id == null) {
            return false;
        }
        for (Lesson lesson : lessons) {
            if (lesson.getLesson_id().equals(id)) {
                lessons.remove(lesson);
                return true;
            }
        }
        return false;
    }
}
