package com.example.eduworldspring.service;

import com.example.eduworldspring.model.Subject;
import com.example.eduworldspring.dto.subject.SubjectCreateUpdateDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SubjectServiceImpl implements SubjectService {

    private ArrayList<Subject> subjects = new ArrayList<>();

    @Override
    public Subject createSubject(SubjectCreateUpdateDto subjectCreateUpdateDto) {
        Subject subject = Subject.toSubject(subjectCreateUpdateDto);
        subjects.add(subject);
        return subject;
    }

    @Override
    public Subject getSubject(Long id) {
        if (id == null) {
            return null;
        }

        for (Subject subject : subjects) {
            if (subject.getId().equals(id)){
                return subject;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    @Override
    public Boolean updateSubject(SubjectCreateUpdateDto subjectCreateUpdateDto, Long id) {
        Subject updatedSubject = Subject.toSubject(subjectCreateUpdateDto);
        updatedSubject.setId(id);

        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getId().equals(updatedSubject.getId())) {
                subjects.set(i, updatedSubject);
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean deleteSubject(Long id) {
        if (id == null) {
            return false;
        }

        for (Subject subject : subjects) {
            if (subject.getId().equals(id)){
                subjects.remove(subject);
                return true;
            }
        }
        return false;
    }
}