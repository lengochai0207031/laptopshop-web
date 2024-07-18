package vn.hoidanit.laptopshop.controllers.client;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import vn.hoidanit.laptopshop.domain.Order;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.domain.dto.RegisterDTO;
import vn.hoidanit.laptopshop.services.OrderService;
import vn.hoidanit.laptopshop.services.ProductService;
import vn.hoidanit.laptopshop.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class homePageController {

    private final ProductService productService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final OrderService orderService;

    public homePageController(ProductService productService, UserService userService, PasswordEncoder passwordEncoder,
            OrderService orderService) {
        this.productService = productService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.orderService = orderService;
    }

    @GetMapping("/")
    public String getHomePage(Model model,
            @RequestParam(value = "page", defaultValue = "1") int page) {
        // Ensure the page number is not less than 1
        int currentPage = page < 1 ? 0 : page - 1;

        Pageable pageable = PageRequest.of(currentPage, 4);
        Page<Product> productPage = (Page<Product>) this.productService.fetchProducts(pageable);

        // Using method references for cleaner code
        List<Product> products = productPage.getContent();

        model.addAttribute("products", products);
        model.addAttribute("currentPage", currentPage + 1); // User-friendly page numbering (starting from 1)
        model.addAttribute("totalPages", productPage.getTotalPages());

        return "client/homepage/show";
    }

    @GetMapping("/register")
    public String getRegister(Model model) {
        model.addAttribute("register", new RegisterDTO());
        return "client/auth/register";
    }

    @PostMapping("/register")
    public String handleRegister(
            @ModelAttribute("register") @Valid RegisterDTO registerDTO,
            BindingResult bindingResult) {

        // validate
        if (bindingResult.hasErrors()) {
            return "client/auth/register";
        }

        User user = this.userService.mapRegistertoUser(registerDTO);
        String hashPassword = this.passwordEncoder.encode(user.getPassWord());
        user.setPassWord(hashPassword);
        user.setRole(this.userService.getRoleName("USER"));
        // save
        this.userService.handleSaveUser(user);
        return "redirect:/login";

    }

    @RequestMapping("/login")
    public String getLogin(Model model) {
        return "client/auth/login";
    }

    @RequestMapping("/access_denied")
    public String getLogout(Model model) {
        return "client/auth/denpy";
    }

    @GetMapping("/order-history")
    public String getOrderHistoryPage(Model model, HttpServletRequest request) {
        User currentUser = new User();// null
        HttpSession session = request.getSession(false);
        long id = (long) session.getAttribute("id");
        currentUser.setId(id);

        List<Order> orders = this.orderService.fetchOrderByUser(currentUser);
        model.addAttribute("orders", orders);

        return "client/cart/order-history";
    }

    @GetMapping("/products")
    public String getProductPage(Model model, @RequestParam("page") Optional<String> pageOptional) {
        int page = 1;
        try {
            if (pageOptional.isPresent()) {
                // convert from String to int
                page = Integer.parseInt(pageOptional.get());
            } else {
                // page = 1
            }
        } catch (Exception e) {
            // page = 1
            // TODO: handle exception
        }

        Pageable pageable = PageRequest.of(page - 1, 6);
        Page<Product> prs = this.productService.fetchProducts(pageable);
        List<Product> products = prs.getContent();

        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", prs.getTotalPages());
        return "client/product/product";
    }
}
