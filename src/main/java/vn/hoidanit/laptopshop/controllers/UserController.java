package vn.hoidanit.laptopshop.controllers;

import org.springframework.web.bind.annotation.RestController;


import vn.hoidanit.laptopshop.services.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@Controller

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")

    public String getHome(Model model) {
      String test  = this.userService.handleHellos();
      model.addAttribute("eric", test);
        return "hello";

        // ở đay return ko có duôi nha cmmm 
    
}
    @RequestMapping("/admin/user")
    public String getUser(Model model) {
        String test  = this.userService.handleHellos();
        model.addAttribute("eric", test);
        return "admin/user/create";
   
    
 
}
}


