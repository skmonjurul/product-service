package com.skmonjurul.product_service.service;

import com.skmonjurul.product_service.exception.ResourceNotFoundException;
import com.skmonjurul.product_service.openapi.model.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Map;


@Service
public class FakeStoreProductService implements ProductService{
    
    private static final String URL = "https://fakestoreapi.com/products";
    
    private final RestTemplate restTemplate;
    
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public List<Product> getAllProducts() {
        return restTemplate.getForObject(URL, List.class);
    }
    
    @Override
    public Product getProductById(String id) {
        Product product = restTemplate.getForObject(URL + "/" + id, Product.class);
        if (product == null)
            throw new ResourceNotFoundException("Product with id " + id + " not found");
        return product;
    }
    
    @Override
    public Product createProduct(Product product) {
        return restTemplate.postForObject(URL, product, Product.class);
    }
    
    @Override
    public Product updateProduct(String id, Product product){
        HttpEntity<Product> entity = new HttpEntity<>(product);
        return restTemplate
                .exchange(URL + "/{id}", HttpMethod.PUT, entity, Product.class, Map.of("id", id))
                .getBody();
    }
    
    @Override
    public Product deleteProduct(String id) {
        return restTemplate
                .exchange(URL + "/{id}", HttpMethod.DELETE, null, Product.class, Map.of("id", id))
                .getBody();
    }
}
