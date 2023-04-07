package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.mvc;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.dto.OrderCreateDto;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.Order;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.OrderProduct;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.Product;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.repository.OrderRepository;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.repository.ProductRepository;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.repository.UserRepository;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.service.OrderService;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class OrderMvcController {
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    private final ProductRepository productRepository;

    private final ProductService productService;

    public OrderMvcController(OrderService orderService, OrderRepository orderRepository, UserRepository userRepository, ProductRepository productRepository, ProductService productService) {
        this.orderService = orderService;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;

        this.productService = productService;
    }

    @GetMapping("/orders/index")
    public String viewOrders(Model model) {
        model.addAttribute("orders", orderService.getAll());
        return "orders";
    }
    @GetMapping("/newOrderForm")
    public String newOrderForm(Model model) {
        OrderCreateDto orderCreateDto = new OrderCreateDto();
        model.addAttribute("orderCreateDto", orderCreateDto);




        return "createOrder";
    }

    @PostMapping("/saveOrder")
    public String saveOrder(@ModelAttribute("orderCreateDto")OrderCreateDto orderCreateDto) {

        orderService.create(orderCreateDto);
        return "redirect:/orders/index";
    }



}
