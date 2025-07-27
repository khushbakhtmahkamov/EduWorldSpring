package com.example.eduworldspring.service;

import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.mapper.LessonMapper;
import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.dto.lesson.LessonCreateUpdateDto;
import com.example.eduworldspring.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;

    @Override
    public Lesson createLesson(LessonCreateUpdateDto lessonCreateUpdateDto) {
        if (lessonCreateUpdateDto == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Lesson data cannot be null");
        }

        Lesson lesson = lessonMapper.toLesson(
                lessonCreateUpdateDto,
                ThreadLocalRandom.current().nextLong(1, 100)
        );

        return lessonRepository.save(lesson);
    }

    @Override
    public Lesson getLesson(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Lesson ID cannot be null");
        }

        return lessonRepository.findById(id)
                .orElseThrow(() -> new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Lesson not found"));
    }

    @Override
    public ArrayList<Lesson> getLessons() {
        return new ArrayList<>(lessonRepository.findAll());
    }

    @Override
    public Boolean deleteLesson(Long id) {
        if (!lessonRepository.existsById(id)) {
            throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Lesson not found");
        }

        lessonRepository.deleteById(id);

        return true;
    }

    @Override
    public Boolean updateLesson(Long id, LessonCreateUpdateDto lessonCreateUpdateDto) {
        Lesson existing = lessonRepository.findById(id)
                .orElseThrow(() -> new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Lesson not found"));

        // Обновляем поля через маппер
        Lesson updated = lessonMapper.toLesson(lessonCreateUpdateDto, existing.getId());

        lessonRepository.save(updated);
        return true;
    }
}
