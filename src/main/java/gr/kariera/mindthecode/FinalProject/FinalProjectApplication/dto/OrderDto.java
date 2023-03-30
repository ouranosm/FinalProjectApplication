package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class OrderDto {
    private Integer id;

    private BigDecimal totalQuantity;

    private BigDecimal totalPrice;

    private UserDto user;

    private Set<OrderProductDto> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(BigDecimal totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Set<OrderProductDto> getProducts() {
        return products;
    }

    public void setProducts(Set<OrderProductDto> products) {
        this.products = products;
    }
}
