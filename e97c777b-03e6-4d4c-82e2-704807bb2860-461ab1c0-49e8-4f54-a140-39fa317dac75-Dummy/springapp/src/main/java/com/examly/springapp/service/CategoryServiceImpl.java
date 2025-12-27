package com.examly.springapp.service;
import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Category;
import com.examly.springapp.repository.CategoryRepo;

@Service
public class CategoryServiceImpl  implements CategoryService{
    private final CategoryRepo catrepo;
    public CategoryServiceImpl(CategoryRepo catrepo){
        this.catrepo=catrepo;
    }

    public Category addCategory(Category category){
        return catrepo.save(category);
    }
    public  List<Category> getAllCategories(){
        return catrepo.findAll();
    }

    public Category getCategoryById(Long id){
        return catrepo.findById(id).orElse(null);
    }
    public Category updateCategory(Category category, Long id){
        Category toBeUpdated=getCategoryById(id);
        if(toBeUpdated==null)
            return null;
        toBeUpdated.setCategoryName(category.getCategoryName());
        toBeUpdated.setProducts(category.getProducts());
        return catrepo.save(toBeUpdated);
    }

    public Page<Category> getPagination(int pageNumber,int pageSize){
        Pageable pageable=PageRequest.of(pageNumber, pageSize);
        return catrepo.findAll(pageable);
    }
    public void deleteById(Long id){
        if (!catrepo.existsById(id)) {
        throw new RuntimeException("Category not found");
        }
       catrepo.deleteById(id);
    }
}
