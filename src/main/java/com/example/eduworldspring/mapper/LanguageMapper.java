package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.language.LanguageCreateDto;
import com.example.eduworldspring.dto.language.LanguageDto;
import com.example.eduworldspring.model.Language;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface LanguageMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "isActive", source = "languageCreateDto.isActive")
    Language toLanguage(LanguageCreateDto languageCreateDto);

    LanguageDto toLanguageDto(Language language);

    void updateLanguage(LanguageCreateDto languageCreateDto, @MappingTarget Language language);
}
