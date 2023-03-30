package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.service;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.Product;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getById(Integer id) {
        return productRepository.findById(id).orElseThrow(()->new RuntimeException("Product with id: " + id + " not found"));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Could not delete product with id: " + id);
        }

    }

    @Override
    public void update(Integer id, Product product) {
        Product product1 = productRepository.findById(id).orElseThrow();
        product1.setPrice(product.getPrice());
        product1.setName(product.getName());
        productRepository.save(product1);

    }
}
