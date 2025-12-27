package com.examly.springapp.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.examly.springapp.model.Category;
import com.examly.springapp.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService catserv;
    public CategoryController(CategoryService catserv){
        this.catserv=catserv;
    }
    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        return ResponseEntity.status(201).body(catserv.addCategory(category));
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories=catserv.getAllCategories();
        if(categories.isEmpty())
            return ResponseEntity.status(204).build();
        return ResponseEntity.ok(catserv.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id ){
        return ResponseEntity.ok(catserv.getCategoryById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable Long id ){
        return ResponseEntity.ok(catserv.updateCategory(category, id));
    }

    @GetMapping("/page/{pageNumber}/{pageSize}")
    public ResponseEntity<Page<Category>> getPagination(@PathVariable int pageNumber, @PathVariable int pageSize){
        return ResponseEntity.ok(catserv.getPagination(pageNumber,pageSize));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        catserv.deleteById(id);
        return ResponseEntity.ok("deleted successfully");
    }
}
