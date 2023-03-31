package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.dto;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.OrderProduct;

import java.util.Set;

public class OrderCreateDto {

    public Integer userId;

    public String address;

    public Set<OrderProductCreateDto> orderProductCreateDto;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<OrderProductCreateDto> getOrderProductCreateDto() {
        return orderProductCreateDto;
    }

    public void setOrderProductCreateDto(Set<OrderProductCreateDto> orderProductCreateDto) {
        this.orderProductCreateDto = orderProductCreateDto;
    }
}
