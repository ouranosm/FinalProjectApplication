package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.dto;

import java.math.BigDecimal;

public class ProductDto {
    private Integer id;

    private String name;

    private String photo;

    private BigDecimal price;

    public ProductDto() {
    }

    public ProductDto(Integer id, String name, String photo, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.price = price;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
