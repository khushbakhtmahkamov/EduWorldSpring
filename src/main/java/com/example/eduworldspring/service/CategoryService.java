package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.category.CategoryCreateUpdateDto;
import com.example.eduworldspring.dto.category.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto addCategory(CategoryCreateUpdateDto category);
    void deleteCategory(Long id);
    CategoryDto getByName(String name);
    CategoryDto getById(Long id);
    List<CategoryDto> getCategories();
    CategoryDto updateCategory(Long id, CategoryCreateUpdateDto category);
}
