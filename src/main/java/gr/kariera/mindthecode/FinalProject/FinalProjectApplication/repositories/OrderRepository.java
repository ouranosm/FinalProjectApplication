package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.repositories;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
