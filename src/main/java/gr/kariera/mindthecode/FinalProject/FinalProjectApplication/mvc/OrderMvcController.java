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
//    @PostMapping("/addProduct")
//    public String addProductToOrder(@RequestParam Integer orderId, @ModelAttribute OrderProduct orderProduct, Model model ){
//
//        Order a= orderService.getById(orderId);
//        Set<OrderProduct> products = a.getOrderProducts();
//        for(OrderProduct op :products){
//            if(op.getProduct().getId().equals(orderProduct.getProduct().getId())){
//                op.setQuantity(orderProduct.getQuantity().add(op.getQuantity()));
//                products.add(op);
//                a.setOrderProducts(products);
//                orderRepository.save(a);
//                model.addAttribute("products",findProductsInOrder(a));
//
//
//                return "redirect:/orders/index";
//            }
//        }
//        products.add(orderProduct);
//        a.setOrderProducts(products);
//        orderRepository.save(a);
//        model.addAttribute("products",findProductsInOrder(a));
//        return "redirect:/orders/index";
////Todo find products by id from orderproducts grammi 65 pernw ola ta orders ara kai ta id
//        //Todo vazwta products sto model attributes
//    }

//    private List<Product> findProductsInOrder (Order order){
//        List<Integer> productIds = new ArrayList<>();
//        for(OrderProduct op :order.getOrderProducts()){
//            productIds.add(op.getProduct().getId());
//        }
//        List<Product> products = new ArrayList<>();
//        for(Integer prodid : productIds){
//            products.add(productService.getById(prodid));
//        }
//        return products;
//    }



}
