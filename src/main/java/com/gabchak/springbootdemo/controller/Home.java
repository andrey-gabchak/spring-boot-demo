package com.gabchak.springbootdemo.controller;

import com.gabchak.springbootdemo.dao.CategoryRepository;
import com.gabchak.springbootdemo.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Home {

    private CategoryRepository categoryRepository;

    @Autowired
    public Home(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        return Optional.of(categoryRepository.findAll())
                .map(ResponseEntity::ok)
                .orElseGet(ResponseEntity.notFound()::build);
    }

}
