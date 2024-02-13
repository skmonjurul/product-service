//package com.skmonjurul.product_service.entity;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//
//import java.util.List;
//import java.util.UUID;
//
//@Entity(name = "categories")
//public class MysqlCategoryEntity implements CategoryEntity<UUID> {
//
//    @Id private UUID id;
//    private String name;
//    private List<MysqlProductEntity> products;
//
//    public UUID getId() {
//        return id;
//    }
//
//    public void setId(UUID id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<MysqlProductEntity> getProducts() {
//        return products;
//    }
//
//    public void setProducts(List<MysqlProductEntity> products) {
//        this.products = products;
//    }
//}
