package com.skmonjurul.product_service.service;

import com.skmonjurul.product_service.entity.FakestoreProductEntity;
import com.skmonjurul.product_service.entity.ProductEntity;
import com.skmonjurul.product_service.openapi.model.Product;
import com.skmonjurul.product_service.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class FakeStoreProductService implements ProductService {
    private final ProductRepository productRepository;
    
    public FakeStoreProductService(ProductRepository productRepository) {
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
    
    private Product productEntityToProduct(ProductEntity productEntity) {
        Product product = new Product(productEntity.getTitle(), productEntity.getPrice(), productEntity.getCategory());
        return product.id(productEntity.getId())
                .description(productEntity.getDescription())
                .image(productEntity.getImage());
        
    }
    
    private ProductEntity productToProductEntity(Product product) {
        FakestoreProductEntity productEntity = new FakestoreProductEntity();
        productEntity.setTitle(product.getTitle());
        productEntity.setPrice(product.getPrice());
        productEntity.setCategory(product.getCategory());
        productEntity.setDescription(product.getDescription());
        productEntity.setImage(product.getImage());
        return productEntity;
    }
}
