package vn.hoidanit.laptopshop.services;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.hoidanit.laptopshop.domain.Products;
import vn.hoidanit.laptopshop.repository.ProDuctRepository;
@Service
public class ProductService {
    private final ProDuctRepository proDuctRepository;
    public ProductService(ProDuctRepository proDuctRepository) {
        this.proDuctRepository = proDuctRepository;
    }


public Products ProductSave(Products products){

    Products  saveProDuct = this.proDuctRepository.save(products);
         return saveProDuct ;
}
    
public Products getCeateProduct(Products products){

    Products saveProDuct = this.proDuctRepository.save(products);
    return saveProDuct;
} 
    // details products
   public Products detailsProduct(int id){
    Products detailProducts = this.proDuctRepository.findById(id);
    return detailProducts;
   }

 //  display products
 public List<Products> getAllProducts() {
    return proDuctRepository.findAll();
}

// deatail products

 public Products getUpdateProducts(int id) {
    Products updateProducts = this.proDuctRepository.findById(id);
    return updateProducts;
 }

 // delete products
 public void deleteProDuct(int id) {
    this.proDuctRepository.deleteById(id);
}
}
