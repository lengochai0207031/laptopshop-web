package vn.hoidanit.laptopshop.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hoidanit.laptopshop.domain.Products;
@Repository
public interface ProDuctRepository  extends JpaRepository <Products , Integer>{
   
    List<Products>findAll();
    Products save(Products product);
    Products findById(int id);


}
