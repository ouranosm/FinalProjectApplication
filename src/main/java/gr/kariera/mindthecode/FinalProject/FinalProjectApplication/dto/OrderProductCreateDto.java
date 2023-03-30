package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.dto;

import java.math.BigDecimal;

public class OrderProductCreateDto {

    private Integer productId;

    private BigDecimal quantity;

    public Integer getProductId() {
        return productId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }
}
