package com.skmonjurul.product_service.service;

import com.skmonjurul.product_service.openapi.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomProductService implements ProductService{
    @Override
    public List<Product> getAllProducts() {
        return null;
    }
    
    @Override
    public Product getProductById(String id) {
        return null;
    }
    
    @Override
    public Product createProduct(Product product) {
        return null;
    }
    
    @Override
    public Product updateProduct(String id, Product product) {
        return null;
    }
    
    @Override
    public Product deleteProduct(String id) {
        return null;
    }
}
