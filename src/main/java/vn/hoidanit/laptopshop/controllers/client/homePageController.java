package vn.hoidanit.laptopshop.controllers.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class homePageController {
     @GetMapping("/client/home")
     public String getHomePage(Model model) {
         return "client/homepage/home";
     }
     
}
