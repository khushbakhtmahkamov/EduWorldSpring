package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.category.CategoryCreateUpdateDto;
import com.example.eduworldspring.dto.category.CategoryDto;
import com.example.eduworldspring.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    Category toCategory(CategoryCreateUpdateDto categoryCreateUpdateDto);

    CategoryDto toCategoryDto(Category category);

    void updateCategoryFromDto(CategoryCreateUpdateDto dto, @MappingTarget Category entity);
}
