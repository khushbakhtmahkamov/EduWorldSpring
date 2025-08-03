package com.example.eduworldspring.repository;

import com.example.eduworldspring.model.Category;
import com.example.eduworldspring.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<Language, Long> {

}
