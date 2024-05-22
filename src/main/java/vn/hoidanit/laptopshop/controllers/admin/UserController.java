package vn.hoidanit.laptopshop.controllers.admin;

import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.services.UploadService;
import vn.hoidanit.laptopshop.services.UserService;

import java.util.ArrayList;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UploadService uploadService;

    public UserController(UserService userService, PasswordEncoder passwordEncoder, UploadService uploadService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.uploadService = uploadService;

    }

    @RequestMapping("/")

    public String getHome(Model model) {
        List<User> arrUsers = this.userService.getAllUsersByEmail("1@gmail.com");
        System.out.println(arrUsers);
        model.addAttribute("newUser", new User());
        return "hello";

        // ở đay return ko có duôi nha cmmm

    }

    @GetMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getUserPage();
        System.out.println("check >>>>>" + users);
        model.addAttribute("users1", users);
        return "admin/user/table_users";
    }

    @GetMapping("/admin/user/{id}")
    public String getDetailUser(Model model, @PathVariable long id) {
        User user = this.userService.getAllUsersById(id);
        System.out.println("check >>>> " + user);
        // user bên này thì chuyền bên user . bên kia như z nha chứ sao không hiển dữ
        // liệu lên đưoẹc nha bjan
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "/admin/user/detailUser";
    }

    @GetMapping("/admin/user/create") // GET
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping(value = "/admin/user/create")
    public String createUserPage(Model model,
            @ModelAttribute("newUser") @Valid User user,
            BindingResult bindingResult,
            @RequestParam("fileName") MultipartFile file) {
        System.out.println(" run here " + user);
        // validate the file nha bạn hai

        // valid

        List<FieldError> errors = new ArrayList<FieldError>();
        errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {

            System.out.println(">>>>>>> " + error.getObjectName() + ": " + error.getField());
            ;
        }

        if (bindingResult.hasErrors()) {
            return "/admin/user/create";

        }
        ///
        // upload file nha bạn hải
        String imagesUploadString = this.uploadService.handleSaveUploadFile(file, "avatar");
        String hashPassword = this.passwordEncoder.encode(user.getPassWord());
        user.setAvatar(imagesUploadString);
        user.setPassWord(hashPassword);
        user.setRole(this.userService.getRoleName(user.getRole().getName()));
        // save
        this.userService.handleSaveUser(user);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/update/{id}")
    public String getUpdatePage(Model model, @PathVariable long id) {
        User updateUser = this.userService.getAllUsersById(id);
        System.out.println("checkk >>>>> " + updateUser);
        model.addAttribute("newUser", updateUser);

        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String postUpdate(Model model, @ModelAttribute("newUser") User hoidanit) {
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

    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUseString(Model model, @PathVariable long id) {
        // User user = new User();
        // user.setId(id);
        User user = this.userService.getAllUsersById(id);
        System.out.println("check >>>> " + user);
        // user bên này thì chuyền bên user . bên kia như z nha chứ sao không hiển dữ
        // liệu lên đưoẹc nha bjan
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        model.addAttribute("newUser", new User());

        return "admin/user/delete";
    }

    @PostMapping("/admin/user/delete")
    public String postDeleteUser(Model model, @ModelAttribute("newUser") User eric) {
        // System.out.println("check >>>> " + eric);
        this.userService.deleteUser(eric.getId());
        return "redirect:/admin/user";
    }

}
