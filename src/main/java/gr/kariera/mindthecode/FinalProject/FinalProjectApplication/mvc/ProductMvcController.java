package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.mvc;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.Product;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductMvcController {

    private final  ProductService productService;

    public ProductMvcController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/index")
    public String viewProducts(Model model) {
        model.addAttribute("products", productService.getAll());
        return "productsAdmin";
    }
    @GetMapping("/newProductForm")
    public String newProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.create(product);
        return "redirect:/products/index";
    }
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value = "id") Integer id, Model model) {
        Product product = productService.getById(id);
        model.addAttribute("product", product);
        return "redirect:/products/index";
    }
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable (value = "id") Integer id) {
        productService.deleteById(id);
        return "redirect:/products/index";
    }
}
