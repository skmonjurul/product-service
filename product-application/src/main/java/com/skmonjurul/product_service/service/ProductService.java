package com.skmonjurul.product_service.service;

import com.skmonjurul.product_service.openapi.model.Product;

import java.net.URISyntaxException;
import java.util.List;

public interface ProductService {
    
    List<Product> getAllProducts();
    
    Product getProductById(String id);
    
    Product createProduct(Product product);
    
    Product updateProduct(String id, Product product);
    
    Product deleteProduct(String id);
}
