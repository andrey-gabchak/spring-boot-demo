package com.gabchak.springbootdemo.controller.external.model;

import com.gabchak.springbootdemo.model.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryDto {
    private String categoryName;

    public CategoryDto(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryDto() {
    }

    public static List<CategoryDto> of(List<Category> categories) {
        return categories.stream()
                .map(CategoryDto::of)
                .collect(Collectors.toList());
    }

    public static CategoryDto of(Category category) {
        return new CategoryDto(category.getCategoryName());
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
