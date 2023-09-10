package com.skmonjurul.product_service.repository;


import com.skmonjurul.product_service.entity.FakestoreProductEntity;
import com.skmonjurul.product_service.entity.ProductEntity;
import com.skmonjurul.product_service.exception.ResourceNotFoundException;
import com.skmonjurul.shared_library.web.client.RestTemplateClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class FakestoreProductRepository implements ProductRepository{
    
    private static final String URL = "https://fakestoreapi.com/products";
    
    private final RestTemplateClient restTemplate;
    
    public FakestoreProductRepository(RestTemplateClient restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<ProductEntity> getAllProducts() {
        FakestoreProductEntity[] products = restTemplate.getForObject(URL, FakestoreProductEntity[].class);
        assert products != null;
        return List.of(products);
    }
    
    @Override
    public ProductEntity getProduct(String id) {
        FakestoreProductEntity product = restTemplate.getForObject(URL + "/" + id, FakestoreProductEntity.class);
        if (product == null)
            throw new ResourceNotFoundException("Product with id " + id + " not found");
        return product;
    }
    
    @Override
    public ProductEntity createProduct(ProductEntity product) {
        return restTemplate.postForObject(URL, product, FakestoreProductEntity.class);
    }
    
    @Override
    public ProductEntity updateProduct(String id, ProductEntity product) {
        HttpEntity<ProductEntity> entity = new HttpEntity<>(product);
        return restTemplate
                .exchange(URL + "/{id}", HttpMethod.PUT, entity, FakestoreProductEntity.class, Map.of("id", id))
                .getBody();
    }
    
    @Override
    public ProductEntity deleteProduct(String id) {
        return restTemplate
                .exchange(URL + "/{id}", HttpMethod.DELETE, null, FakestoreProductEntity.class,
                        Map.of("id", id)).getBody();
    }
}
