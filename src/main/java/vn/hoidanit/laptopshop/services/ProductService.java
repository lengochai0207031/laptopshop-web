package vn.hoidanit.laptopshop.services;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product SaveProduct(Product product) {
        return this.productRepository.save(product);
    }

    public List<Product> getAllProducts() {

        return this.productRepository.findAll();
    }

    public List<Product> fetchProducts() {

        return this.productRepository.findAll();
    }

    public Product getProductDetail(Long id) {
        return this.productRepository.findById(id).get();
    }

    public Product getUpdateProduct(Long id) {

        Product product = this.productRepository.findById(id).get();
        return product;
    }

    public void deleteProductById(long id) {
        this.productRepository.deleteById(id);
    }
}
