package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.taskanswer.TaskAnswerDto;
import com.example.eduworldspring.dto.taskanswer.TaskAnswerRequestDto;
import com.example.eduworldspring.model.TaskAnswer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskAnswerMapper {

    TaskAnswerDto toDto(TaskAnswer taskAnswer);
    TaskAnswer toModel(TaskAnswerDto taskAnswerDto);

    TaskAnswer toModelFromRequest(TaskAnswerRequestDto dto);
}
