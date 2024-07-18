package vn.hoidanit.laptopshop.controllers.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.Valid;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.services.ProductService;
import vn.hoidanit.laptopshop.services.UploadService;

@Controller
public class ProductController {

    private final ProductService productService;
    private final UploadService uploadService;

    public ProductController(ProductService productService, UploadService uploadService) {
        this.productService = productService;
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/product")
    public String getProduct(Model model,
            @RequestParam(value = "page", defaultValue = "1") int page) {
        Pageable pageable = PageRequest.of(page - 1, 2);
        Page<Product> getAllProducts = this.productService.fetchProducts(pageable);
        List<Product> products = getAllProducts.getContent();
        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", getAllProducts.getTotalPages());
        return "admin/product/show";
    }

    @GetMapping("/admin/product/create")
    public String getCreateProduct(Model model) {
        model.addAttribute("product", new Product());
        return "admin/product/create";
    }

    @PostMapping("/admin/product/create")
    public String createProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult,
            @RequestParam("fileName") MultipartFile file, Model model) {

        // valid

        List<FieldError> errors = new ArrayList<FieldError>();
        errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {

            System.out.println(">>>>>>> " + error.getObjectName() + ": " + error.getField());
            ;
        }

        if (bindingResult.hasErrors()) {
            return "admin/product/create";

        }
        ///
        String imagesProduct = this.uploadService.handleSaveUploadFile(file, "product"); // này là dẫn tơi cái tệp mà
                                                                                         // bạn muốn lưu hình ảnh ở đấy
        product.setImage(imagesProduct);
        this.productService.createProduct(product);
        return "redirect:/admin/product";

    }

    @GetMapping("/admin/product/detail/{id}")
    public String getDeatilString(Model model, @PathVariable long id) {
        Optional<Product> product = this.productService.fetchProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("id", id);
        return "admin/product/detail";
    }

    @GetMapping("/admin/product/update/{id}")
    public String getUpdateProduct(Model model, @PathVariable long id) {
        Optional<Product> product = this.productService.fetchProductById(id);
        model.addAttribute("product", product);
        model.addAttribute("id", id);
        return "admin/product/update";
    }

    @PostMapping("/admin/product/update")
    public String postUpdateProduct(Model model, @ModelAttribute("product") Product product,
            @RequestParam("fileName") MultipartFile file) {
        // Fetch the product to be updated by ID
        Optional<Product> existingProductOptional = this.productService.fetchProductById(product.getId());

        // Check if the product exists
        if (existingProductOptional.isPresent()) {
            Product existingProduct = existingProductOptional.get();

            // Handle file upload and get the image path if a new file is provided
            String imageFilePath = existingProduct.getImage(); // Keep the current image
            if (!file.isEmpty()) {
                imageFilePath = this.uploadService.handleSaveUploadFile(file, "product");
            }

            // Update product information
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setImage(imageFilePath);
            existingProduct.setDetailDesc(product.getDetailDesc());
            existingProduct.setShortDesc(product.getShortDesc());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setSold(product.getSold());
            existingProduct.setFactory(product.getFactory());
            existingProduct.setTarget(product.getTarget());

            // Save the updated product
            this.productService.createProduct(existingProduct);
        } else {
            // If product does not exist, add an error message to the model
            model.addAttribute("error", "Product not found");
            return "error/404"; // Return to an error page or handle accordingly
        }

        // Redirect to the admin product list page
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String getProductDetailPage(Model model, @PathVariable long id) {

        model.addAttribute("product", new Product());
        model.addAttribute("id", id);
        return "admin/product/delete";
    }

    @PostMapping("/admin/product/delete")
    public String showDeleteProductPage(Model model, @ModelAttribute("product") Product product) {
        this.productService.deleteProduct(product.getId());
        return "redirect:/admin/product";
    }

}
