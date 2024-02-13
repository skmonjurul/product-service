package com.skmonjurul.product_service.entity;

public class FakestoreProductEntity implements ProductEntity<String> {
    
    private String id;
    
    private String title;
    
    private String description;
    
    private String price;
    
    private String image;
    
    private String category;
    
    
    public FakestoreProductEntity() {}
    public FakestoreProductEntity(String id, String title, String description, String price, String image, String category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.image = image;
        this.category = category;
    }
    
    @Override
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    @Override
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Override
    public String getPrice() {
        return price;
    }
    
    public void setPrice(String price) {
        this.price = price;
    }
    
    @Override
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {
        private String id;
        private String title;
        private String description;
        private String price;
        private String image;
        private String category;
        
        public Builder id(String id) {
            this.id = id;
            return this;
        }
        
        public Builder title(String title) {
            this.title = title;
            return this;
        }
        
        public Builder description(String description) {
            this.description = description;
            return this;
        }
        
        public Builder price(String price) {
            this.price = price;
            return this;
        }
        
        public Builder image(String image) {
            this.image = image;
            return this;
        }
        
        public Builder category(String category) {
            this.category = category;
            return this;
        }
        public FakestoreProductEntity build() {
            return new FakestoreProductEntity(id, title, description, price, image, category);
        }
    }
}
