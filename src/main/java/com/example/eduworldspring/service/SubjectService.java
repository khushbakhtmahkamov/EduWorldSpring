package com.example.eduworldspring.service;


import com.example.eduworldspring.model.Subject;
import com.example.eduworldspring.dto.subject.SubjectCreateUpdateDto;

import java.util.ArrayList;


public interface SubjectService {
    Subject createSubject(SubjectCreateUpdateDto subjectCreateUpdateDto);
    Subject getSubject(Long id);
    ArrayList<Subject> getSubjects();
    Boolean updateSubject(SubjectCreateUpdateDto subjectCreateUpdateDto, Long id);
    Boolean deleteSubject(Long id);
}