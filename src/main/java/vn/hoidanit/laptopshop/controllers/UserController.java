package vn.hoidanit.laptopshop.controllers;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.services.UserService;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;







@Controller

public class UserController {

    private UserService userService;
    public UserController(UserService userService ) {
        this.userService = userService;
        
    }

    @RequestMapping("/")

    public String getHome(Model model) {
        List<User> arrUsers = this.userService.getAllUsersByEmail("1@gmail.com");
        System.out.println(arrUsers);
      model.addAttribute("newUser", new User());
        return "hello";

        // ở đay return ko có duôi nha cmmm 
    
}
@RequestMapping("/admin/user")
public String getUserPage(Model model) {
    List<User> users = this.userService.getUserPage();
    System.out.println("check >>>>>"+users);
    model.addAttribute("users1", users);
    return "admin/user/table_users";
}

@RequestMapping("/admin/user/create") // GET
public String getCreateUserPage(Model model) {
    model.addAttribute("newUser", new User());
    return "admin/user/create";
}

@RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
public String createUserPage(Model model, @ModelAttribute("newUser") User hoidanit) {
    System.out.println(" run here " + hoidanit);
    this.userService.handleSaveUser(hoidanit);
    return "redirect:/admin/user";
}
}


