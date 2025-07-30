package com.example.eduworldspring.controller;

import com.example.eduworldspring.dto.lesson.LessonDto;
import com.example.eduworldspring.dto.lesson.LessonCreateUpdateDto;
import com.example.eduworldspring.service.LessonService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {
    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/{id}")
    public LessonDto getLesson(@PathVariable Long id) {
        return lessonService.getLesson(id);
    }

    @GetMapping
    public List<LessonDto> getAllLessons() {
        return lessonService.getLessons();
    }

    @PostMapping
    public LessonDto addLesson(@Valid @RequestBody LessonCreateUpdateDto dto) {
        return lessonService.createLesson(dto);
    }

    @PutMapping("/{id}")
    public void updateLesson(@Valid @RequestBody LessonCreateUpdateDto dto,
                             @PathVariable Long id) {
        lessonService.updateLesson(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteLesson(@PathVariable Long id) {
        lessonService.deleteLesson(id);
    }
}
