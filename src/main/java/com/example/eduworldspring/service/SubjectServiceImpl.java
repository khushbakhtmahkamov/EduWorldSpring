package com.example.eduworldspring.service;

import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.mapper.SubjectMapper;
import com.example.eduworldspring.dto.subject.SubjectCreateUpdateDto;
import com.example.eduworldspring.model.Subject;
import com.example.eduworldspring.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;

    @Override
    public Subject createSubject(SubjectCreateUpdateDto subjectCreateUpdateDto) {
        if (subjectCreateUpdateDto == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "SubjectCreateUpdateDto cannot be null");
        }

        Subject subject = subjectMapper.toSubject(subjectCreateUpdateDto);
        subjectRepository.save(subject);
        return subject;
    }

    @Override
    public Subject getSubject(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "id cannot be null");
        }

        return subjectRepository.findById(id).orElseThrow(() ->
                new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Subject with id " + id + " not found")
        );
    }

    @Override
    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Boolean updateSubject(SubjectCreateUpdateDto subjectCreateUpdateDto, Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "id cannot be null");
        }
        if (subjectCreateUpdateDto == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "SubjectCreateUpdateDto cannot be null");
        }

        Subject subject = subjectRepository.findById(id).orElseThrow(() ->
                new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Subject with id " + id + " not found")
                );

        subject.setTitle(subjectCreateUpdateDto.getTitle());
        subject.setDescription(subjectCreateUpdateDto.getDescription());
        subject.setCredits(subjectCreateUpdateDto.getCredits());
        subject.setCode(subjectCreateUpdateDto.getCode());

        subjectRepository.save(subject);
        return true;
    }

    @Override
    public Boolean deleteSubject(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "id cannot be null");
        }

        subjectRepository.findById(id).orElseThrow(() ->
                new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Subject with id " + id + " not found")
        );

        subjectRepository.deleteById(id);
        return true;
    }
}