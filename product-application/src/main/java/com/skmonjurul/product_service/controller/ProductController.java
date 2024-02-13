package com.skmonjurul.product_service.controller;

import com.skmonjurul.product_service.openapi.api.ProductApi;
import com.skmonjurul.product_service.openapi.model.Product;
import com.skmonjurul.product_service.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ProductController implements ProductApi {
    
    private final ProductService<String> productService;
    
    public ProductController(ProductService<String> productService) {
        this.productService = productService;
    }
    
    @Override
    public ResponseEntity<Product> createProduct(Product product, String xTenantId, String xTraceId) {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }
    
    @Override
    public ResponseEntity<Product> deleteProduct(String id, String xTenantId, String xTraceId) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }
    
    @Override
    public ResponseEntity<Product> getProductById(String id, String xTenantId, String xTraceId) {
        return ResponseEntity.ok(productService.getProductById(id));
    }
    
    @Override
    public ResponseEntity<List<Product>> getProducts(String xTenantId, String xTraceId) {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    
    @Override
    public ResponseEntity<Product> updateProduct(String id, Product product, String xTenantId, String xTraceId) {
        return ResponseEntity.ok(productService.updateProduct(id, product));
    }
}
