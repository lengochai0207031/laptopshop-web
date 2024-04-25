package vn.hoidanit.laptopshop.controllers;

import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.laptopshop.services.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")

    public String getHome() {
      String test  = this.userService.handleHellos();
        return "hello";

        // ở đay return ko có duôi nha cmmm 
    
}
}


