package vn.hoidanit.laptopshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.laptopshop.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;



// @Controller

// public class UserController {
//     @RequestMapping("/")
   
    
//     public String getHome() {
//         return "Hello Controllers";
    
// }
// }


@RestController
public class UserController {
    private UserService userService;
    

public UserController(UserService userService) {
        this.userService = userService;
    }


@GetMapping("")
    public String getHome() {
        return this.userService.handleHellos();
    
}
}