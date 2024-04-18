package vn.hoidanit.laptopshop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellController {
@GetMapping("/")
public String index(){
    return "Hello World form SpringBoot cố lên nha hải ?";
}

@GetMapping("/user")
public String userPage() {
    return "Only users can access this page.";
}

@GetMapping("/admin")
public String admiPage() {
    return "Only admin can access this page.";
}


}
