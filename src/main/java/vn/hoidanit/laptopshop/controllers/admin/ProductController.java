package vn.hoidanit.laptopshop.controllers.admin;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.services.ProductService;
import vn.hoidanit.laptopshop.services.UploadService;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ProductController {

    private final ProductService productService;
    private final UploadService uploadService;

    
    public ProductController(ProductService productService, UploadService uploadService) {
        this.productService = productService;
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/product")
    public String getProduct(Model model) {
        List<Product> getAllProducts = new ArrayList<Product>();
        getAllProducts = this.productService.getAllProducts();
        model.addAttribute("products", getAllProducts);
        return "admin/product/show";
    }

    @GetMapping("/admin/product/create")
    public String getCreateProduct(Model model) {
        model.addAttribute("product", new Product());
        return "admin/product/create";
    }

    @PostMapping("/admin/product/create")
    public String createProduct(@ModelAttribute("product") Product product, @RequestParam("fileName") MultipartFile file, Model model) {
        
            String imagesProduct = this.uploadService.handleSaveUploadFile(file, "product"); // này là dẫn tơi cái tệp mà bạn  muốn lưu hình ảnh ở đấy
            product.setImage(imagesProduct);
            this.productService.SaveProduct(product);
            return "redirect:/admin/product";
       
    }

    @GetMapping("/admin/product/detail/{id}")
    public String getMethodName(Model model,  @PathVariable long id) {
        Product product = this.productService.getProductDetail(id);
        model.addAttribute("product", product);
        model.addAttribute("id",id);
        return "admin/product/detail";
    }


    @GetMapping("/admin/product/update/{id}")
    public String getUpdateProduct(Model model, @PathVariable long id) {
        Product product = this.productService.getUpdateProduct(id);
    model.addAttribute("product", product);
    model.addAttribute("id", id);
        return "admin/product/update";
    }
    

    @PostMapping("/admin/product/update")
    public String postUpdateProduct(Model model, @ModelAttribute("product") Product product, @RequestParam("fileName") MultipartFile file) {
        // Lấy sản phẩm cần cập nhật theo ID
        Product existingProduct = this.productService.getUpdateProduct(product.getId());
    
        // Kiểm tra nếu sản phẩm tồn tại
        if (existingProduct != null) {
            // Xử lý upload file ảnh và lấy đường dẫn ảnh nếu có tệp mới
            String imageFilePath = existingProduct.getImage(); // Giữ lại ảnh hiện tại
            if (!file.isEmpty()) {
                imageFilePath = this.uploadService.handleSaveUploadFile(file, "product");
            }
    
            // Cập nhật thông tin sản phẩm
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setImage(imageFilePath);
            existingProduct.setDetailDesc(product.getDetailDesc());
            existingProduct.setShortDesc(product.getShortDesc());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setSold(product.getSold());
            existingProduct.setFactory(product.getFactory());
            existingProduct.setTarget(product.getTarget());
    
            // Lưu sản phẩm đã cập nhật
            this.productService.SaveProduct(existingProduct);
        } else {
            // Xử lý trường hợp sản phẩm không tồn tại
            model.addAttribute("errorMessage", "Product not found for update.");
            return "error/error"; // Trang báo lỗi (nếu có trang lỗi riêng)
        }
    
        // Chuyển hướng về trang danh sách sản phẩm quản trị
        return "redirect:/admin/product";
    }
    
    
    
    
}
