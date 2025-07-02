package com.example.eduworldspring.service;

import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.mapper.SubjectMapper;
import com.example.eduworldspring.model.Subject;
import com.example.eduworldspring.dto.subject.SubjectCreateUpdateDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectMapper subjectMapper;
    private ArrayList<Subject> subjects = new ArrayList<>();

    @Override
    public Subject createSubject(SubjectCreateUpdateDto subjectCreateUpdateDto) {
        if (subjectCreateUpdateDto == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "SubjectCreateUpdateDto cannot be null");
        }

        Subject subject = subjectMapper.toSubject(subjectCreateUpdateDto, ThreadLocalRandom.current().nextLong(1, 100));
        subjects.add(subject);
        return subject;
    }

    @Override
    public Subject getSubject(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "id cannot be null");
        }

        for (Subject subject : subjects) {
            if (subject.getId().equals(id)){
                return subject;
            }
        }
        throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Subject with id " + id + " not found");
    }

    @Override
    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    @Override
    public Boolean updateSubject(SubjectCreateUpdateDto subjectCreateUpdateDto, Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "id cannot be null");
        }
        if (subjectCreateUpdateDto == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "SubjectCreateUpdateDto cannot be null");
        }

        Subject updatedSubject = subjectMapper.toSubject(subjectCreateUpdateDto, id);

        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getId().equals(updatedSubject.getId())) {
                subjects.set(i, updatedSubject);
                return true;
            }
        }
        throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Subject with id " + id + " not found");
    }

    @Override
    public Boolean deleteSubject(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "id cannot be null");
        }

        for (Subject subject : subjects) {
            if (subject.getId().equals(id)){
                subjects.remove(subject);
                return true;
            }
        }
        throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Subject with id " + id + " not found");
    }
}