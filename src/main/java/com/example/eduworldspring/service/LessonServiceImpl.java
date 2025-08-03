package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.lesson.LessonCreateUpdateDto;
import com.example.eduworldspring.dto.lesson.LessonDto;
import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.mapper.LessonMapper;
import com.example.eduworldspring.model.Lesson;
import com.example.eduworldspring.model.Subject;
import com.example.eduworldspring.model.User;
import com.example.eduworldspring.repository.LessonRepository;
import com.example.eduworldspring.repository.SubjectRepository;
import com.example.eduworldspring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final LessonMapper lessonMapper;
    private final UserRepository userRepository;
    private final SubjectRepository subjectRepository;

    @Override
    public LessonDto createLesson(LessonCreateUpdateDto dto) {
        User user = userRepository.findById(dto.getTeacher_id())
                .orElseThrow(() -> new BusinessRuntimeException(
                        BusinessExceptionCode.NOT_FOUND,
                        "User with id " + dto.getTeacher_id() + " not found"));

        Subject subject = subjectRepository.findById(dto.getSubject_id())
                .orElseThrow(() -> new BusinessRuntimeException(
                        BusinessExceptionCode.NOT_FOUND,
                        "Subject with id " + dto.getSubject_id() + " not found"));

        if (dto.getEnd_date() != null && dto.getStart_date() != null &&
                dto.getEnd_date().isBefore(dto.getStart_date())) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Incorrect date range");
        }

        Lesson lesson = lessonMapper.toLesson(dto, user, subject);
        lessonRepository.save(lesson);
        return lessonMapper.toLessonDto(lesson);
    }

    @Override
    public LessonDto getLesson(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Lesson ID cannot be null");
        }

        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new BusinessRuntimeException(
                        BusinessExceptionCode.NOT_FOUND,
                        "Lesson with id " + id + " not found"));

        return lessonMapper.toLessonDto(lesson);
    }

    @Override
    public List<LessonDto> getLessons() {
        return lessonRepository.findAll()
                .stream()
                .map(lessonMapper::toLessonDto)
                .toList();
    }

    @Override
    public void deleteLesson(Long id) {
        if (!lessonRepository.existsById(id)) {
            throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Lesson not found");
        }
        lessonRepository.deleteById(id);
    }

    @Override
    public void updateLesson(Long id, LessonCreateUpdateDto dto) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Lesson ID cannot be null");
        }

        User user = userRepository.findById(dto.getTeacher_id())
                .orElseThrow(() -> new BusinessRuntimeException(
                        BusinessExceptionCode.NOT_FOUND,
                        "User with id " + dto.getTeacher_id() + " not found"));

        Subject subject = subjectRepository.findById(dto.getSubject_id())
                .orElseThrow(() -> new BusinessRuntimeException(
                        BusinessExceptionCode.NOT_FOUND,
                        "Subject with id " + dto.getSubject_id() + " not found"));

        Lesson lesson = lessonRepository.findById(id)
                .orElseThrow(() -> new BusinessRuntimeException(
                        BusinessExceptionCode.NOT_FOUND,
                        "Lesson with id " + id + " not found"));

        lessonMapper.updateLessonFromDto(dto, user, subject, lesson);
        lessonRepository.save(lesson);
    }
}
