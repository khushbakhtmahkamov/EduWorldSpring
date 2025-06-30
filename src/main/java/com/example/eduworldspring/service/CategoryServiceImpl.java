package com.example.eduworldspring.service;

import com.example.eduworldspring.model.Category;
import com.example.eduworldspring.dto.category.CategoryCreateUpdateDto;
import com.example.eduworldspring.dto.category.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private List<Category> categories = new ArrayList<>();


    @Override
    public void addCategory(CategoryCreateUpdateDto categoryCreateUpdateDto) {

        Category category = new Category();
       /* category = category.toCategory(categoryCreateUpdateDto);
        if(category !=null && category.getName() != null) {
            categories.add(category);
        }*/
    }



    @Override
    public boolean removeCategoryById(Long id) {
        Iterator<Category> iterator = categories.iterator();
        while (iterator.hasNext()) {
            Category category = iterator.next();
            if (category.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public CategoryDto getByName(String name) {
        for (Category category : categories) {
            if (category.getName().equals(name)) {
                //return category.toCategoryDto(category);
            }
        }
        return null;
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for (Category category : categories) {
          //  categoryDtos.add(category.toCategoryDto(category));
        }
        return categoryDtos;
    }
}
