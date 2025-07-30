package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.language.LanguageCreateDto;
import com.example.eduworldspring.dto.language.LanguageDto;
import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.mapper.LanguageMapper;
import com.example.eduworldspring.model.Language;
import com.example.eduworldspring.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository languageRepository;
    private final LanguageMapper languageMapper;

    @Override
    public LanguageDto createLanguage(LanguageCreateDto languageCreateDto) {
        if (languageCreateDto == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "languageCreateDto can't be null");
        }

        Language language = languageMapper.toLanguage(languageCreateDto);
        languageRepository.save(language);
        return languageMapper.toLanguageDto(language);
    }

    @Override
    public List<LanguageDto> getAllLanguages() {
        return languageRepository.findAll()
                .stream()
                .map(languageMapper::toLanguageDto)
                .toList();
    }

    @Override
    public LanguageDto getLanguageById(Long id) {
        Language language = languageRepository.findById(id)
                .orElseThrow(() -> new BusinessRuntimeException(
                        BusinessExceptionCode.NOT_FOUND,
                        "Language with id " + id + " not found"
                ));

        return languageMapper.toLanguageDto(language);
    }

    @Override
    public void deleteLanguageById(Long id) {
        languageRepository.findById(id)
                .orElseThrow(() -> new BusinessRuntimeException(
                        BusinessExceptionCode.NOT_FOUND,
                        "Language with id " + id + " not found"
                ));

        languageRepository.deleteById(id);
    }

    @Override
    public void updateLanguage(Long id, LanguageCreateDto languageCreateDto) {
        if (languageCreateDto == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "languageCreateDto can't be null");
        }

        Language language = languageRepository.findById(id)
                .orElseThrow(() -> new BusinessRuntimeException(
                        BusinessExceptionCode.NOT_FOUND,
                        "Language with id " + id + " not found"
                ));

        languageMapper.updateLanguage(languageCreateDto, language);
        languageRepository.save(language);
    }
}
