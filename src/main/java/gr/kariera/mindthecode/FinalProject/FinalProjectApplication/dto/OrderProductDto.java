package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.dto;

import java.math.BigDecimal;

public class OrderProductDto {
    private ProductDto product;

    private BigDecimal quantity;

    private BigDecimal subTotalPrice;

    public ProductDto getProduct() {
        return product;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubTotalPrice() {
        return subTotalPrice;
    }

    public void setSubTotalPrice(BigDecimal subTotalPrice) {
        this.subTotalPrice = subTotalPrice;
    }
}
