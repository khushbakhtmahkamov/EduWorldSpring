package com.example.eduworldspring.service;

import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.mapper.CategoryMapper;
import com.example.eduworldspring.model.Category;
import com.example.eduworldspring.dto.category.CategoryCreateUpdateDto;
import com.example.eduworldspring.dto.category.CategoryDto;
import com.example.eduworldspring.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryDto addCategory(CategoryCreateUpdateDto categoryCreateUpdateDto) {
        if (categoryCreateUpdateDto == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "categoryCreateUpdateDto can't be null");
        }

        Category category = categoryMapper.toCategory(categoryCreateUpdateDto);
        categoryRepository.save(category);
        return categoryMapper.toCategoryDto(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.findById(id).orElseThrow(() ->
                new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "category with id " + id + " not found")
        );
        categoryRepository.deleteById(id);
    }

    @Override
    public CategoryDto getByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "name can't be null");
        }

        Category category = categoryRepository.findByName(name);

        if (category == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND,
                    "category with name " + name + " not found");
        }

        return categoryMapper.toCategoryDto(category);
    }

    @Override
    public CategoryDto getById(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "id can't be null");
        }
        Category category = categoryRepository.findById(id).orElseThrow(() ->
                new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "category with id " + id + " not found")
        );

        return categoryMapper.toCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toCategoryDto)
                .toList();
    }

    @Override
    public CategoryDto updateCategory(Long id, CategoryCreateUpdateDto categoryCreateUpdateDto) {
        if (categoryCreateUpdateDto == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST,
                    "categoryCreateUpdateDto can't be null");
        }

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND,
                        "category with id " + id + " not found"));

        categoryMapper.updateCategoryFromDto(categoryCreateUpdateDto, category);

        Category updatedCategory = categoryRepository.save(category);
        return categoryMapper.toCategoryDto(updatedCategory);
    }
}
