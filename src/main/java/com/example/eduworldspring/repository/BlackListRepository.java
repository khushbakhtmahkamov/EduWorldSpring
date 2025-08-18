package com.example.eduworldspring.repository;

import com.example.eduworldspring.model.BlackList;
import com.example.eduworldspring.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListRepository extends JpaRepository<BlackList, Long> {
    BlackList findByName(String name);
}
