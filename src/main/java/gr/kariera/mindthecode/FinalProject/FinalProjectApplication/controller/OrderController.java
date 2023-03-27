package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.controller;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.Order;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrder() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return new ResponseEntity<>(orderService.create(order), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Order> updateOrderById(@PathVariable Integer id, @RequestBody Order order) {
        orderService.update(id, order);
        return ResponseEntity.ok(orderService.getById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Integer id) {
        orderService.deleteById(id);
    }

}
