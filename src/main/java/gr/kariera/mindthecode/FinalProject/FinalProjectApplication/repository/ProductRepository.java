package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.repository;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
