package com.example.eduworldspring.controller;

import com.example.eduworldspring.model.Category;
import com.example.eduworldspring.service.CategoryService;
import com.example.eduworldspring.tdo.category.CategoryCreateUpdateDto;
import com.example.eduworldspring.tdo.category.CategoryDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;
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

    @GetMapping("/{name}")
    public CategoryDto getCategoryByName(@PathVariable String name) {
        return categoryService.getByName(name);
    }

}
