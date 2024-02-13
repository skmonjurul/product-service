package com.skmonjurul.product_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name = "products")
public class MysqlProductEntity implements ProductEntity<UUID> {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column
    private String title;
    @Column
    private String price;
    @Column
    private String category;
    @Column
    private String description;
    @Column
    private String image;
    
    public void setId(UUID id) {
        this.id = id;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    @Override
    public UUID getId() {
        return id;
    }
    
    @Override
    public String getTitle() {
        return title;
    }
    
    @Override
    public String getPrice() {
        return price;
    }
    
    @Override
    public String getCategory() {
        return category;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
    
    @Override
    public String getImage() {
        return image;
    }
}
