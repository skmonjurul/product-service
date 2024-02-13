package com.skmonjurul.product_service.service;

import com.skmonjurul.product_service.entity.FakestoreProductEntity;
import com.skmonjurul.product_service.entity.ProductEntity;
import com.skmonjurul.product_service.openapi.model.Product;
import com.skmonjurul.product_service.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Primary
public class FakeStoreProductService implements ProductService<String> {
    private final ProductRepository<ProductEntity<String>> productRepository;
    
    public FakeStoreProductService(ProductRepository<ProductEntity<String>> productRepository) {
        this.productRepository = productRepository;
    }
    
    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts()
                .stream()
                .map(this::productEntityToProduct)
                .toList();
    }
    
    @Override
    public Product getProductById(String id) {
        return productEntityToProduct(productRepository.getProduct(id));
    }
    
    @Override
    public Product createProduct(Product product) {
        return productEntityToProduct(productRepository.createProduct(productToProductEntity(product)));
    }
    
    @Override
    public Product updateProduct(String id, Product product){
        return productEntityToProduct(productRepository.updateProduct(id, productToProductEntity(product)));
    }
    
    @Override
    public Product deleteProduct(String id) {
        return productEntityToProduct(productRepository.deleteProduct(id));
    }
    
    public ProductEntity<String> productToProductEntity(Product product) {
        return FakestoreProductEntity.builder()
                .title(product.getTitle())
                .price(product.getPrice())
                .category(product.getCategory())
                .description(product.getDescription())
                .image(product.getImage())
                .build();
    }
}
