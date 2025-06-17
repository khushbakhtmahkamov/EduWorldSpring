package com.example.eduworldspring.controller;

import com.example.eduworldspring.model.Category;
import com.example.eduworldspring.service.CategoryService;
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
    public List<Category> getAllCategories() {
        return categoryService.getCategories();
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
        return category;
    }

}
