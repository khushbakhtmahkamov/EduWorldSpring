package com.example.eduworldspring.repository;

import com.example.eduworldspring.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category, Long> {
    Category findByName(String name);
}
