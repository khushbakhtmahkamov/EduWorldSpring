package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.progress.ProgressCreateUpdateDto;
import com.example.eduworldspring.dto.progress.ProgressDto;
import com.example.eduworldspring.model.Progress;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ProgressMapper {
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "subject", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Progress toEntity(ProgressCreateUpdateDto dto);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.name", target = "userName")
    @Mapping(source = "subject.id", target = "subjectId")
    @Mapping(source = "subject.title", target = "subjectTitle")
    ProgressDto toDto(Progress entity);
}