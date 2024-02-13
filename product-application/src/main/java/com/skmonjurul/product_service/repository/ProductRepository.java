package com.skmonjurul.product_service.repository;

import com.skmonjurul.product_service.entity.ProductEntity;

import java.util.List;

public abstract class ProductRepository<T> {
    
    public abstract List<T> getAllProducts();
    
    public abstract T getProduct(String id);
    
    public abstract T createProduct(T product);
    
    public abstract T updateProduct(String id, T product);
    
    public abstract T deleteProduct(String id);
}
