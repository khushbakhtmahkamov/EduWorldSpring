package com.example.eduworldspring.controller;

import com.example.eduworldspring.service.CategoryService;
import com.example.eduworldspring.dto.category.CategoryCreateUpdateDto;
import com.example.eduworldspring.dto.category.CategoryDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return categoryService.getCategories();
    }

    @PostMapping
    public CategoryCreateUpdateDto createCategory(@RequestBody CategoryCreateUpdateDto categoryCreateUpdateDto) {
        categoryService.addCategory(categoryCreateUpdateDto);
        return categoryCreateUpdateDto;
    }

    @DeleteMapping("/{id}")
    public boolean deleteCategory(@PathVariable Long id) {
        return categoryService.removeCategoryById(id);
    }

    /*@PutMapping("/{id}")
    public CategoryDto updateCategory(@PathVariable Long id, @RequestBody CategoryCreateUpdateDto categoryCreateUpdateDto) {
        categoryCreateUpdateDto.setId(id);
        categoryService.addCategory(categoryCreateUpdateDto);
        return categoryService.getByName(categoryCreateUpdateDto.getName());
    }*/

    @GetMapping("/{name}")
    public CategoryDto getCategoryByName(@PathVariable String name) {
        return categoryService.getByName(name);
    }



}
