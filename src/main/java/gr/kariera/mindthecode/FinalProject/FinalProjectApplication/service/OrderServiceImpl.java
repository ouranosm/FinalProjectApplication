package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.service;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.dto.OrderCreateDto;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.dto.OrderProductCreateDto;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.Order;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.OrderProduct;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.Product;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.User;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.repository.OrderRepository;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.repository.ProductRepository;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;

    private final UserService userService;

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository, UserService userService, ProductRepository productRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Order create(OrderCreateDto orderCreateDto) {

        Order order = new Order();
        BigDecimal totalPrice =new BigDecimal(0);
        BigDecimal totalQuantity = new BigDecimal(0);


        User user = userRepository.findById(orderCreateDto.getUserId()).orElseThrow();
        order.setUser(user);


        for(OrderProductCreateDto orderProductCreateDto : orderCreateDto.orderProductCreateDto) {
            Product product = productRepository.findById(orderProductCreateDto.getProductId()).orElseThrow();

            if (product.getStock().compareTo(orderProductCreateDto.getQuantity()) == -1) {
                throw new RuntimeException(
                        "Insufficient stock for product with id: " + orderProductCreateDto.getProductId());
            }
            product.setStock(product.getStock().subtract(orderProductCreateDto.getQuantity()));
            OrderProduct orderProduct = new OrderProduct(order, product);
            orderProduct.setQuantity(orderProductCreateDto.getQuantity());
            orderProduct.setPrice(product.getPrice().multiply(orderProductCreateDto.getQuantity()));



            order.getOrderProducts().add(orderProduct);
            orderProduct.getProduct().getOrderProducts().add(orderProduct);

            totalQuantity = totalQuantity.add(orderProductCreateDto.getQuantity());
            totalPrice = totalPrice.add(product.getPrice().multiply(orderProductCreateDto.getQuantity()));
        }
        order.setTotalPrice(totalPrice);
        order.setTotalQuantity(totalQuantity);


        //order.setOrderProducts(orderCreateDto.getOrderProducts());
        order.setAddress(orderCreateDto.getAddress());
        user.addOrder(order);

        return orderRepository.save(order);
    }

    @Override
    public Order getById(Integer id) {
        return orderRepository.findById(id).orElseThrow(()->new RuntimeException("Order with id: " + id + " not found"));
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        try {
            orderRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Could not delete order with id: " + id);
        }

    }

    @Override
    public void update(Integer id, Order order) {

    }
}
