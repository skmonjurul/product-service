package com.skmonjurul.product_service.repository;

import com.skmonjurul.product_service.entity.ProductEntity;

import java.util.List;

public interface ProductRepository {
    
    List<ProductEntity> getAllProducts();
    
    ProductEntity getProduct(String id);
    
    ProductEntity createProduct(ProductEntity product);
    
    ProductEntity updateProduct(String id, ProductEntity product);
    
    ProductEntity deleteProduct(String id);
}
