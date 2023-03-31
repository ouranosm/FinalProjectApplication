package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.dto;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.enums.ProductCategory;

import java.math.BigDecimal;

public class ProductCreateDto {
    private String name;

    private String photo;

    private ProductCategory productCategory;

    private BigDecimal stock;

    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
}
