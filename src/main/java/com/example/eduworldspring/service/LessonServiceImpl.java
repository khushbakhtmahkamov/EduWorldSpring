package com.example.eduworldspring.service;

import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.mapper.LessonMapper;
import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.dto.lesson.LessonCreateUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {
    private ArrayList<Lesson> lessons = new ArrayList<>();
    private final LessonMapper lessonMapper;

    @Override
    public Lesson createLesson(LessonCreateUpdateDto lessonCreateUpdateDto) {
        if (lessonCreateUpdateDto == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Lesson cannot be null");

        }
        Lesson lesson = lessonMapper.toLesson(lessonCreateUpdateDto, ThreadLocalRandom.current().nextLong(1, 100));
        lessons.add(lesson);
        return lesson;
    }

    @Override
    public Lesson getLesson(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Lesson id cannot be null");
        }
        for (Lesson lesson : lessons) {
            if (lesson.getLesson_id().equals(id)) {
                return lesson;
            }
        }
        throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Lesson id is not found");
    }

    @Override
    public ArrayList<Lesson> getLessons() {
        return lessons;
    }

    @Override
    public Boolean updateLesson(Long id, LessonCreateUpdateDto lessonCreateUpdateDto) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "id cannot be null");
        }
        if (lessonCreateUpdateDto == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "LessonCreateUpdateDto cannot be null");
        }

        Lesson updatedLesson = lessonMapper.toLesson(lessonCreateUpdateDto, id);
        for (int i = 0; i < lessons.size(); i++) {
            if (lessons.get(i).getLesson_id().equals(id)) {
                lessons.set(i, updatedLesson);
                return true;
            }
        }
        throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Lesson id is not found");
    }

    @Override
    public Boolean deleteLesson(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "id cannot be null");
        }
        for (Lesson lesson : lessons) {
            if (lesson.getLesson_id().equals(id)) {
                lessons.remove(lesson);
                return true;
            }
        }
        throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Lesson id is not found");
    }
}
