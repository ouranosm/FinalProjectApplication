package gr.kariera.mindthecode.FinalProject.FinalProjectApplication.mvc;

import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.Product;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.entity.User;
import gr.kariera.mindthecode.FinalProject.FinalProjectApplication.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserMvcController {
    private final UserService userService;

    public UserMvcController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/index")
    public String viewProducts(Model model) {
        model.addAttribute("users", userService.getAll());
        return "usersAdmin";
    }
    @GetMapping("/newUserForm")
    public String newProductForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "new_user";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/users/index";
    }
    @GetMapping("/showFormForUpdateUser/{id}")
    public String showFormForUpdateUser(@PathVariable(value = "id") Integer id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "update_user";
    }
    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable (value = "id") Integer id) {
        userService.deleteById(id);
        return "redirect:/users/index";
    }
}
