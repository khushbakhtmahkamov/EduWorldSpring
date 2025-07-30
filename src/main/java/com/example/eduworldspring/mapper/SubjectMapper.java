package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.subject.SubjectCreateUpdateDto;
import com.example.eduworldspring.dto.subject.SubjectDto;
import com.example.eduworldspring.model.Category;
import com.example.eduworldspring.model.Subject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SubjectMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "description", source = "scheduleCreateUpdateDto.description")
    Subject toSubject(SubjectCreateUpdateDto scheduleCreateUpdateDto, Category category);

    @Mapping(target = "categoryId", source = "category.id")
    SubjectDto toSubjectDto(Subject subject);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "description", source = "subjectCreateUpdateDto.description")
    void updateSubjectFromDto(SubjectCreateUpdateDto subjectCreateUpdateDto, @MappingTarget Subject subject, Category category);
}