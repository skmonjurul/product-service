package com.skmonjurul.product_service.entity;

public interface ProductEntity<T> {
    T getId();
    
    String getTitle();
    
    String getPrice();
    
    String getCategory();
    
    String getDescription();
    
    String getImage();
}
