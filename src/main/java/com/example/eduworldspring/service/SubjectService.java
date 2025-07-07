package com.example.eduworldspring.service;


import com.example.eduworldspring.model.Subject;
import com.example.eduworldspring.dto.subject.SubjectCreateUpdateDto;

import java.util.List;


public interface SubjectService {
    Subject createSubject(SubjectCreateUpdateDto subjectCreateUpdateDto);
    Subject getSubject(Long id);
    List<Subject> getSubjects();
    Boolean updateSubject(SubjectCreateUpdateDto subjectCreateUpdateDto, Long id);
    Boolean deleteSubject(Long id);
}