package com.example.eduworldspring.controller;

import com.example.eduworldspring.model.Subject;
import com.example.eduworldspring.service.SubjectService;
import com.example.eduworldspring.dto.subject.SubjectCreateUpdateDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subjects")
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/{id}")
    public Subject getSubject(@PathVariable Long id) {
        return subjectService.getSubject(id);
    }

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectService.getSubjects();
    }

    @PostMapping
    public Subject addSubject(@RequestBody SubjectCreateUpdateDto subjectCreateUpdateDto) {
        return subjectService.createSubject(subjectCreateUpdateDto);
    }

    @PutMapping("/{id}")
    public Boolean updateSubject(@RequestBody SubjectCreateUpdateDto subjectCreateUpdateDto, @PathVariable Long id) {
        return subjectService.updateSubject(subjectCreateUpdateDto, id);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteSubject(@PathVariable Long id) {
        return subjectService.deleteSubject(id);
    }
}
