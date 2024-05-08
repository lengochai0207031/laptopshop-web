package vn.hoidanit.laptopshop.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import vn.hoidanit.laptopshop.domain.Products;
import vn.hoidanit.laptopshop.services.ProductService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;







@Controller
public class ProductController {
     private ProductService productService;
      public  ProductController(ProductService productService) {
        this.productService = productService;
    
}

// cái RequestMapping  là cái link  go to on google nha bạn
@RequestMapping("/admin/product")
public  String displayProduct(Model model) {
  List<Products> products = this.productService.getAllProducts();
  model.addAttribute("product", products);
    return "admin/product/create-page";
}

// detail product 

@RequestMapping("/admin/product/{id}")
public String getDetailProduct(Model model, @PathVariable int id) {
    Products product =  this.productService.detailsProduct(id);
    model.addAttribute("id", id).addAttribute("product", product); // Chain attribute additions
    return "admin/product/detail-page";
}





 // create Product 
 //   choose createProduct  go to link create product 
 @RequestMapping("/admin/product/create")
 public String getCreateProduct(Model model) {
    model.addAttribute("product", new Products());
     return "admin/product/create";
 }
 

 // addtion databased int table product

 @RequestMapping (value="/admin/product/create", method=RequestMethod.POST)
 public String createProduct (Model model, @ModelAttribute("product") Products product) {
  System.out.println("check int >>>>>>>>>>"+product);
  this.productService.getCeateProduct(product);
     return "redirect:/admin/product";
 }
 

 @RequestMapping("/admin/product/update-page/{id}")
 public String getUpdateProduct(Model model, @PathVariable int id) {
     Products product = this.productService.getUpdateProducts(id); // Use getDetailProduct (assuming it retrieves details)
     if (product != null) {
         model.addAttribute("product", product);
         return "admin/product/update-page";
     } else {
         // Handle product not found error (e.g., return an error view)
         return "error/product-not-found";
     }
 }
 
 @PostMapping("/admin/product/update-page")
 public String postUpdateProduct(Model model, @ModelAttribute("product") Products product) {
     Products existingProduct = this.productService.getUpdateProducts(product.getId()); // Use getProductById (assuming it retrieves by ID)
     if (existingProduct != null) {
         existingProduct.setName(product.getName());
         existingProduct.setAge(product.getAge());
         this.productService.getCeateProduct(existingProduct); // Use updateProduct for clarity
         return "redirect:/admin/product";
     } else {
         // Handle product not found error (e.g., display an error message)
         model.addAttribute("errorMessage", "Product not found!");
         return "admin/product/update-page"; // Retain the update page with error message
     }
 }
 
 @RequestMapping("/admin/product/delete-page/{id}")
 public String requestMethodName(Model model, @PathVariable int id) {
    model.addAttribute("id", id);
    model.addAttribute("product",new Products());
     return "admin/product/delete-page";
 }
 @PostMapping("/admin/product/delete-page")
 public String postMethodName(Model model ,@ModelAttribute("product") Products products) {
     this.productService.deleteProDuct(products.getId());
    
     
    return "redirect:/admin/product";
 }
 
 
 }



