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

    @GetMapping("/{id}")
    public CategoryDto getCategory(@PathVariable long id) {
        return categoryService.getById(id);
    }

    @PostMapping
    public CategoryDto createCategory(@RequestBody CategoryCreateUpdateDto categoryCreateUpdateDto) {
        return categoryService.addCategory(categoryCreateUpdateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

    @PutMapping("/{id}")
    public CategoryDto updateCategory(@PathVariable Long id, @RequestBody CategoryCreateUpdateDto categoryCreateUpdateDto) {
        return categoryService.updateCategory(id, categoryCreateUpdateDto);
    }

    @GetMapping("/by-name/{name}")
    public CategoryDto getCategoryByName(@PathVariable String name) {
        return categoryService.getByName(name);
    }
}
