package vn.hoidanit.laptopshop.controllers;


import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.repository.UserRepository;
import vn.hoidanit.laptopshop.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





@Controller

public class UserController {

    private UserService userService;
    private  UserRepository userRepository;

    public UserController(UserService userService , UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @RequestMapping("/")

    public String getHome(Model model) {
      String test  = this.userService.handleHellos();
      model.addAttribute("newUser", new User());
        return "hello";

        // ở đay return ko có duôi nha cmmm 
    
}
    @RequestMapping("/admin/user")
    public String getUser(Model model) {
        String test  = this.userService.handleHellos();
        model.addAttribute("newUser", new User());
        return "admin/user/create";
}

@RequestMapping(value = "/admin/user/create1", method = RequestMethod.POST)
  public String createUser(Model model , @ModelAttribute("newUser")User hoidanit) {
    System.out.println("run hear"+hoidanit);
    this.userRepository.save(hoidanit);
      return "hello";
  }
  
}


