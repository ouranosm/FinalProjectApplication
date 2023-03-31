package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.repository;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
