package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.service;



import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.Product;

import java.util.List;

public interface ProductService {

    Product create(Product product);

    Product getById(Integer id);

    List<Product> getAll();

    void deleteById(Integer id);

    void update(Integer id, Product product);
}
