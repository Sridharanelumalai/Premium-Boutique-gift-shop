package com.examly.springapp.service;

import java.util.List;

import com.examly.springapp.model.Product;

public interface ProductService {
    public Product addProduct(Product product);
    public List<Product> getAllProducts();
    public Product getProductById(Long id);
    public Product updateProduct(Product product,Long id);
    public List<Product> getProductsByName(String name);
    public List<Product> getProductsByCategoryName(String categoryName);
}
