package com.example.eduworldspring.model;

import com.example.eduworldspring.dto.category.CategoryCreateUpdateDto;
import com.example.eduworldspring.dto.category.CategoryDto;

import java.util.concurrent.ThreadLocalRandom;

public class Category {
    Long id;
    String name;
    String description;
    boolean isActive;

    public Category() {
    }

    public Category(String name, String description, boolean isActive, Long id) {
        this.name = name;
        this.description = description;
        this.isActive = isActive;
        this.id = id;
    }

    public Category toCategory(CategoryCreateUpdateDto categoryCreateUpdateDto) {
        return new Category(
                categoryCreateUpdateDto.getName(),
                categoryCreateUpdateDto.getDescription(),
                categoryCreateUpdateDto.isActive(),
                ThreadLocalRandom.current().nextLong()
        );
    }

    public CategoryDto toCategoryDto(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.isActive()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
