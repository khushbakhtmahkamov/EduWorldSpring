package com.example.eduworldspring.service;

import com.example.eduworldspring.model.Subject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SubjectServiceImpl implements SubjectService {

    private List<Subject> subjects = new ArrayList<>();

    @Override
    public void addSubject(Subject subject) {
        if (subject != null && subject.getTitle() != null) {
            subjects.add(subject);
        }
    }

    @Override
    public boolean removeSubjectByCode(String code) {
        Iterator<Subject> iterator = subjects.iterator();
        while (iterator.hasNext()) {
            Subject subject = iterator.next();
            if (subject.getCode().equalsIgnoreCase(code)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public Subject getByCode(String code) {
        for (Subject subject : subjects) {
            if (subject.getCode().equalsIgnoreCase(code)) {
                return subject;
            }
        }
        return null;
    }

    @Override
    public List<Subject> getSubjects() {
        return new ArrayList<>(subjects);
    }

    @Override
    public List<Subject> getSubjectsByCredits(int credits) {
        List<Subject> filteredSubjects = new ArrayList<>();
        for (Subject subject : subjects) {
            if (subject.getCredits() == credits) {
                filteredSubjects.add(subject);
            }
        }



        return filteredSubjects;
    }
}