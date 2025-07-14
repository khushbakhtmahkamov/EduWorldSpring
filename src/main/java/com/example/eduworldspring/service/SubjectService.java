package com.example.eduworldspring.service;


import com.example.eduworldspring.dto.subject.SubjectCreateUpdateDto;
import com.example.eduworldspring.dto.subject.SubjectDto;
import com.example.eduworldspring.model.Subject;

import java.util.List;


public interface SubjectService {
    Subject createSubject(SubjectCreateUpdateDto subjectCreateUpdateDto);
    SubjectDto getSubject(Long id);
    List<SubjectDto> getSubjects();
    Boolean updateSubject(SubjectCreateUpdateDto subjectCreateUpdateDto, Long id);
    Boolean deleteSubject(Long id);
}