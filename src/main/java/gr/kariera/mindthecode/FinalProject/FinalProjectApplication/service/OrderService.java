package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.service;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.Order;

import java.util.List;

public interface OrderService {

    Order create(Order order);

    Order getById(Integer id);

    List<Order> getAll();

    void deleteById(Integer id);

    void update(Integer id, Order order);
}
