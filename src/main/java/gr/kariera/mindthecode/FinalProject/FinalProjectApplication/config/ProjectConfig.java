package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.config;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.Product;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.repository.ProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

import static gr.kariera.mindthecode.FinalProject.FinalProjectApplication.enums.ProductCategory.FOOD;

@Component
public class ProjectConfig {
    private final ProductRepository productRepository;

    public ProjectConfig(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Bean
    public void createInitialProduct() {
        List<Product> productList = List.of(new Product("ava", FOOD, "photo1", BigDecimal.valueOf(10), BigDecimal.valueOf(5)));
        productRepository.saveAll(productList);
    }
}
