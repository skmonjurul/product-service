package com.skmonjurul.product_service.service;

import com.skmonjurul.product_service.entity.ProductEntity;
import com.skmonjurul.product_service.openapi.model.Product;

import java.util.List;

public interface ProductService<T> {
    
    List<Product> getAllProducts();
    
    Product getProductById(String id);
    
    Product createProduct(Product product);
    
    Product updateProduct(String id, Product product);
    
    Product deleteProduct(String id);
    
    ProductEntity<T> productToProductEntity(Product product);
    
    default Product productEntityToProduct(ProductEntity<T> productEntity) {
        Product product = new Product(productEntity.getTitle(), productEntity.getPrice(), productEntity.getCategory());
        return product.id(String.valueOf(productEntity.getId()))
                .description(productEntity.getDescription())
                .image(productEntity.getImage());
    }
}
