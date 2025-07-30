package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.language.LanguageCreateDto;
import com.example.eduworldspring.dto.language.LanguageDto;
import com.example.eduworldspring.model.Language;

import java.util.List;

public interface LanguageService {
   LanguageDto createLanguage(LanguageCreateDto languageCreateDto);

   List<LanguageDto> getAllLanguages();

   LanguageDto getLanguageById(Long id);

   void deleteLanguageById(Long id);

   void updateLanguage(Long id, LanguageCreateDto languageCreateDto);
}
