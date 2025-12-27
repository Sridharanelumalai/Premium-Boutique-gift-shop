package com.examly.springapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Product;
import com.examly.springapp.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService prodserv;
    public ProductController(ProductService prodserv){
        this.prodserv=prodserv;
    }
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product prod ){
        return ResponseEntity.status(201).body(prodserv.addProduct(prod));
    }
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(prodserv.getAllProducts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id ){
        return ResponseEntity.ok(prodserv.getProductById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product prod,@PathVariable Long id){
        return ResponseEntity.ok(prodserv.updateProduct(prod,id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<?> getProductsByName(@PathVariable String name){
        List<Product> productsByName=prodserv.getProductsByName(name);
        if(productsByName.isEmpty())
            return ResponseEntity.status(404).body("No products found with name: "+name);
        return ResponseEntity.ok(productsByName);
    }

    @GetMapping("/category/{categoryName}")
    public ResponseEntity<List<Product>> getProductsByCategoryName(@PathVariable String categoryName){
        return ResponseEntity.ok(prodserv.getProductsByCategoryName(categoryName));
    }

}
