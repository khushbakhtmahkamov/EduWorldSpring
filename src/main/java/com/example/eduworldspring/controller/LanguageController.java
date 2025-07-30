package com.example.eduworldspring.controller;

import com.example.eduworldspring.dto.language.LanguageCreateDto;
import com.example.eduworldspring.dto.language.LanguageDto;
import com.example.eduworldspring.model.Language;
import com.example.eduworldspring.model.Role;
import com.example.eduworldspring.service.LanguageService;
import com.example.eduworldspring.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
    private final LanguageService languageService;
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @PostMapping
    public LanguageDto createLanguage(@RequestBody LanguageCreateDto languageCreateDto) {
        return languageService.createLanguage(languageCreateDto);
    }

    @GetMapping
    public List<LanguageDto> getAllLanguages() {
        return languageService.getAllLanguages();
    }

    @GetMapping("/{id}")
    public LanguageDto getLanguageById(@PathVariable Long id) {
        return languageService.getLanguageById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteLanguageById(@PathVariable Long id) {
        languageService.deleteLanguageById(id);
    }

    @PutMapping("/{id}")
    public void updateLanguage(@PathVariable Long id, @RequestBody LanguageCreateDto languageCreateDto) {
        languageService.updateLanguage(id, languageCreateDto);
    }
}
