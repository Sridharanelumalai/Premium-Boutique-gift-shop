package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepo prodrepo;
    public ProductServiceImpl(ProductRepo prodrepo){
        this.prodrepo=prodrepo;
    }

    public Product addProduct(Product product){
        return prodrepo.save(product);
    }
    public List<Product> getAllProducts(){
        return prodrepo.findAll();
    }
    public Product getProductById(Long id){
        return prodrepo.findById(id).orElse(null);
    }

    public Product updateProduct(Product prod, Long id ){
        Product toBeUpdated=getProductById(id);
        if(toBeUpdated==null)
            return null;
        toBeUpdated.setProductName(prod.getProductName());
        toBeUpdated.setDescription(prod.getDescription());
        toBeUpdated.setMovements(prod.getMovements());
        toBeUpdated.setStockEntries(prod.getStockEntries());
        toBeUpdated.setCategory(prod.getCategory());
        return prodrepo.save(toBeUpdated);
    }

    public List<Product> getProductsByName(String name){
        return prodrepo.findByProductName(name);
    }

    public List<Product> getProductsByCategoryName(String categoryName){
        return prodrepo.findByCategory_CategoryName(categoryName);
    }

}
