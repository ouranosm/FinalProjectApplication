package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @Enumerated(value = EnumType.STRING)
    private ProductCategory productCategory;

    private String photo;

    private BigDecimal stock;

    @OneToMany(mappedBy = "product")
    Set<OrderProduct> orderProducts;

    public Product(Integer id, String name, ProductCategory productCategory, String photo, BigDecimal stock, Set<OrderProduct> orderProducts) {
        this.id = id;
        this.name = name;
        this.productCategory = productCategory;
        this.photo = photo;
        this.stock = stock;
        this.orderProducts = orderProducts;
    }

    public Set<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
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
}
