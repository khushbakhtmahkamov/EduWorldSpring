package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.category.CategoryCreateUpdateDto;
import com.example.eduworldspring.dto.category.CategoryDto;

import java.util.List;

public interface CategoryService {
    void addCategory(CategoryCreateUpdateDto category);
    boolean removeCategoryById(Long id);
    CategoryDto getByName(String name);
    List<CategoryDto> getCategories();
}
