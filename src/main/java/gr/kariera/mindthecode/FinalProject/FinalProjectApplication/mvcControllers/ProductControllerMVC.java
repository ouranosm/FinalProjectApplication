package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.mvcControllers;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.Product;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.repository.ProductRepository;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.service.ProductService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductControllerMVC {

    @Autowired
    private final ProductService service;
    private final ProductRepository productRepository;

    public ProductControllerMVC(ProductService service,
                                ProductRepository productRepository) {
        this.service = service;
        this.productRepository = productRepository;
    }

    @GetMapping("/index")
    public String greetings(
            @RequestParam(required = false) String description,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            @RequestParam(defaultValue = "ASC", required = false) String sort,
            @NotNull Model model
    ) {
        model.addAttribute("products", service.getAll());
        model.addAttribute("sort", sort);
        model.addAttribute("description", description);
        return "products";
    }

    @GetMapping("/create")
    public String showCreateForm(@NotNull Model model) {
        model.addAttribute("product",  new Product());
        return "create-or-update-products";
    }
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, @NotNull Model model) {
        model.addAttribute("product",  service.getById(id));
        return "create-or-update-products";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, Model model) {
        service.deleteById(id);
        return "redirect:/products/index";
    }
    @PostMapping("/create-or-update")
    public String saveCreateForm(@RequestParam Optional<Integer> id, @ModelAttribute Product product , Model model) {
        service.create(productRepository.save(product));
        return "redirect:/products/index";
    }
}