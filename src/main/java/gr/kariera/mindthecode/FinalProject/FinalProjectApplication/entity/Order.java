package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String address;

    private BigDecimal totalQuantity;

    private BigDecimal totalPrice;



    @ManyToOne(fetch = FetchType.LAZY, optional = false)

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private User user;

//    @Enumerated(value = EnumType.STRING)
//    private OrderStatus orderStatus;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
            @Column(nullable = false)
    Set<OrderProduct> orderProducts = new HashSet<>();



    public Order() {
    }

    public Order(Integer id, String address, BigDecimal totalQuantity, BigDecimal totalPrice, User user, Set<OrderProduct> orderProducts) {
        this.id = id;
        this.address = address;
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }


}
