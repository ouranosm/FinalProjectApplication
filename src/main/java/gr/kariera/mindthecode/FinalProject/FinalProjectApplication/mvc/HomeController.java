package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.mvc;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.Product;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/index")
    public String showHomePage() {
        return "home";
    }

}
