package vn.hoidanit.laptopshop.controllers.client;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.domain.dto.RegisterDTO;
import vn.hoidanit.laptopshop.services.ProductService;
import vn.hoidanit.laptopshop.services.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class homePageController {

    private final ProductService productService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public homePageController(ProductService productService, UserService userService, PasswordEncoder passwordEncoder) {
        this.productService = productService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/home")
    public String getHomePage(Model model) {
        List<Product> product = this.productService.getAllProducts();
        model.addAttribute("products", product);
        return "client/homepage/home";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("register", new RegisterDTO());
        return "client/auth/register";
    }

    @PostMapping("/register")

    public String posCreateRegister(Model model, @ModelAttribute("register") RegisterDTO registerDTO) {
        User user = this.userService.mapRegistertoUser(registerDTO);
        String hassPasword = this.passwordEncoder.encode(user.getPassWord());

        user.setPassWord(hassPasword);
        user.setRole(this.userService.getRoleName("USER"));
        this.userService.handleSaveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        return "client/auth/login";
    }

}
