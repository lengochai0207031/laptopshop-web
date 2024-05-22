package vn.hoidanit.laptopshop.controllers.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.services.ProductService;

@Controller
public class itemControllers {
    private final ProductService productService;

    public itemControllers(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/client/product/detail/{id}")
    public String getMethodName(Model model, @PathVariable long id) {
        Product product = this.productService.getProductDetail(id);
        model.addAttribute("id", id);
        model.addAttribute("product", product);
        return "client/product/detail";
    }

}
