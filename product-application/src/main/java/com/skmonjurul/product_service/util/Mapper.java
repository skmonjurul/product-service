package com.skmonjurul.product_service.util;

import com.skmonjurul.product_service.entity.FakestoreProductEntity;
import com.skmonjurul.product_service.entity.MysqlProductEntity;
import com.skmonjurul.product_service.entity.ProductEntity;
import com.skmonjurul.product_service.openapi.model.Product;

import java.util.UUID;

public class Mapper<T> {
    Product productEntityToProduct(ProductEntity<T> productEntity) {
        Product product = new Product(productEntity.getTitle(), productEntity.getPrice(), productEntity.getCategory());
        return product.id(String.valueOf(productEntity.getId()))
                .description(productEntity.getDescription())
                .image(productEntity.getImage());
    }
    
    public FakestoreProductEntity productToFakeStoreProductEntity(Product product) {
        return FakestoreProductEntity.builder()
                .title(product.getTitle())
                .price(product.getPrice())
                .category(product.getCategory())
                .description(product.getDescription())
                .image(product.getImage())
                .build();
    }
    
    public MysqlProductEntity productToMySqlProductEntity(Product product) {
        MysqlProductEntity entity = new MysqlProductEntity();
        entity.setCategory(product.getCategory());
        entity.setDescription(product.getDescription());
        entity.setPrice(product.getPrice());
        entity.setTitle(product.getTitle());
        entity.setImage(product.getImage());
        return entity;
    }
}
