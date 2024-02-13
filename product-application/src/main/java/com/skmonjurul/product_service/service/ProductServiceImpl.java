package com.skmonjurul.product_service.service;

import com.skmonjurul.product_service.entity.MysqlProductEntity;
import com.skmonjurul.product_service.entity.ProductEntity;
import com.skmonjurul.product_service.openapi.model.Product;
import java.util.Collections;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
//@Primary
public class ProductServiceImpl implements ProductService<UUID> {
    @Override
    public List<Product> getAllProducts() {
        return Collections.emptyList();
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
    
    @Override
    public ProductEntity<UUID> productToProductEntity(Product product) {
        MysqlProductEntity entity = new MysqlProductEntity();
        entity.setCategory(product.getCategory());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        entity.setTitle(product.getTitle());
        entity.setImage(product.getImage());
        return entity;
    }
}
