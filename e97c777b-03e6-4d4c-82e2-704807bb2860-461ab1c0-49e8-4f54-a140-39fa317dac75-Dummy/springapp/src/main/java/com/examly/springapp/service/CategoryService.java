package com.examly.springapp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.examly.springapp.model.Category;

public interface CategoryService {
    public Category addCategory(Category prod);
    public List<Category> getAllCategories();
    public Category getCategoryById(Long id);
    public Category updateCategory(Category prod, Long id);
    public Page<Category> getPagination(int pageNumber,int pageSize);
    public void deleteById(Long id);
}
