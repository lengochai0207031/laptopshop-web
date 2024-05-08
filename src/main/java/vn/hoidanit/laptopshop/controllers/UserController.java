package vn.hoidanit.laptopshop.controllers;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.services.UserService;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;












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

@RequestMapping("/admin/user/{id}")
public String getDetailUser(Model model , @PathVariable long id) {
   User user = this.userService.getAllUsersById(id);
    System.out.println("check >>>> "+user);
    // user bên này thì chuyền bên user . bên  kia như z nha chứ sao không hiển dữ liệu lên đưoẹc nha bjan 
    model.addAttribute("user", user);
    model.addAttribute("id", id);
    return "/admin/user/detailUser" ;
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




@RequestMapping("/admin/user/updateUsers/{id}")
public String getUpdatePage(Model model, @PathVariable long id) {
    User updateUser  =this.userService.getAllUsersById(id);
    System.out.println("checkk >>>>> " + updateUser);
    model.addAttribute("newUser", updateUser);
   
    return "admin/user/updateUser";
}

@PostMapping("/admin/user/updateUsers")
public String postUpdate(Model model  ,@ModelAttribute("newUser") User hoidanit) {
    User updateUser = this.userService.getAllUsersById(hoidanit.getId());
    if (updateUser != null) {
         updateUser.setEmail(hoidanit.getEmail());
         updateUser.setFullName(hoidanit.getFullName());
         updateUser.setAddress(hoidanit.getAddress());
         updateUser.setPhone(hoidanit.getPhone());
         this.userService.handleSaveUser(updateUser); 
    }
    return "redirect:/admin/user";
}


  
@RequestMapping("/admin/user/delete/{id}")
public String getDeleteUseString(Model model ,@PathVariable long id) {
    // User user = new User();
    // user.setId(id);
    model.addAttribute("id", id);
    model.addAttribute("newUser",new User());

    return "admin/user/delete";
}

@PostMapping("/admin/user/delete")
public String postDeleteUser(Model model, @ModelAttribute("newUser") User eric) {
    // System.out.println("check >>>> " + eric);
    this.userService.deleteUser(eric.getId());
    return  "redirect:/admin/user" ;
}

}


