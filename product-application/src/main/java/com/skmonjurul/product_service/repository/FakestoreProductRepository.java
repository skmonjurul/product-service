package com.skmonjurul.product_service.repository;


import com.skmonjurul.product_service.entity.FakestoreProductEntity;
import com.skmonjurul.product_service.entity.ProductEntity;
import com.skmonjurul.product_service.exception.ResourceNotFoundException;
import com.skmonjurul.shared_library.web.client.RestTemplateClient;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FakestoreProductRepository extends ProductRepository<ProductEntity<String>>{
    
    private static final String URL = "https://fakestoreapi.com/products";
    
    private final RestTemplateClient restTemplate;
    
    public FakestoreProductRepository(RestTemplateClient restTemplate) {
        this.restTemplate = restTemplate;
    }
    @Override
    public List<ProductEntity<String>> getAllProducts() {
        return List.of(Optional.ofNullable(restTemplate.getForObject(URL, FakestoreProductEntity[].class))
                .orElseGet(ArrayUtils::toArray));
    }
    
    @Override
    public ProductEntity<String> getProduct(String id) {
        return Optional.ofNullable(restTemplate.getForObject(URL + "/" + id, FakestoreProductEntity.class))
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
    }
    
    @Override
    public ProductEntity<String> createProduct(ProductEntity<String> product) {
        return restTemplate.postForObject(URL, product, FakestoreProductEntity.class);
    }
    
    @Override
    public ProductEntity<String> updateProduct(String id, ProductEntity<String> product) {
        HttpEntity<ProductEntity<String>> entity = new HttpEntity<>(product);
        return restTemplate
                .exchange(URL + "/{id}", HttpMethod.PUT, entity, FakestoreProductEntity.class, Map.of("id", id))
                .getBody();
    }
    
    @Override
    public ProductEntity<String> deleteProduct(String id) {
        return restTemplate
                .exchange(URL + "/{id}", HttpMethod.DELETE, null, FakestoreProductEntity.class,
                        Map.of("id", id)).getBody();
    }
}
