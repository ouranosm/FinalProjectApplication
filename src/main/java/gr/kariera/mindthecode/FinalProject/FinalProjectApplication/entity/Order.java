package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.enums.OrderStatus;
import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order")
    Set<OrderProduct> orderProducts;

    public Order(Integer id, String address, User user, OrderStatus orderStatus, Set<OrderProduct> orderProducts) {
        this.id = id;
        this.address = address;
        this.user = user;
        this.orderStatus = orderStatus;
        this.orderProducts = orderProducts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Set<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }
}
