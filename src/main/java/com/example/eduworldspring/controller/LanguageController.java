package com.example.eduworldspring.controller;

import com.example.eduworldspring.model.Language;
import com.example.eduworldspring.model.Role;
import com.example.eduworldspring.service.LanguageService;
import com.example.eduworldspring.service.RoleService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
    private LanguageService languageService;
    public LanguageController(LanguageService languageService) {
        this.languageService = languageService;
    }
    @PostMapping
    public void createLanguage (@RequestBody Language language) {
        languageService.create(language);
    }

    @GetMapping({"/{id}"})
    public Language getLanguageById(@PathVariable Long id) {
        return languageService.getById(id);
    }
}
