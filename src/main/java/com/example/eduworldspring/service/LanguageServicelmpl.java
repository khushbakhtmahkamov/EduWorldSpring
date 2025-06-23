package com.example.eduworldspring.service;

import com.example.eduworldspring.model.Language;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageServicelmpl implements LanguageService {
    List<Language> languages = new ArrayList<>();
    @Override
    public void create(Language language) {
        if (language != null && language.getName() != null) {
            languages.add(language);
        }
    }

    @Override
    public Language getById(Long id) {
        for (Language language : languages) {
            if (language.getId().equals(id)) {
                return language;
            }
        }
        return null;
    }
}
