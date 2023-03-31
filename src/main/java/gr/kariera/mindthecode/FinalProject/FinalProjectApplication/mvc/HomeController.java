package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/index")
    public String showHomePage() {
        return "home";
    }
}
