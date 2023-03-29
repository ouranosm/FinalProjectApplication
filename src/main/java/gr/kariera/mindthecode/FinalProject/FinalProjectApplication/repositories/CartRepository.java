package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.repositories;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
