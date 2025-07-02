package com.example.eduworldspring.controller;

import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.service.LessonService;
import com.example.eduworldspring.dto.lesson.LessonCreateUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @GetMapping("/{id}")
    public Lesson getLesson(@PathVariable Long id) {
        return lessonService.getLesson(id);
    }

    @GetMapping
    public List<Lesson> getAllLessons() {
        return lessonService.getLessons();
    }

    @PostMapping
    public Lesson addLesson(@RequestBody LessonCreateUpdateDto lessonCreateUpdateDto) {
        return lessonService.createLesson(lessonCreateUpdateDto);
    }

    @PutMapping("/{id}")
    public Boolean updateLesson(@RequestBody LessonCreateUpdateDto lessonCreateUpdateDto,
                                @PathVariable Long id) {
        return lessonService.updateLesson(lessonCreateUpdateDto, id);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteLesson(@PathVariable Long id) {
        return lessonService.deleteLesson(id);
    }
}
