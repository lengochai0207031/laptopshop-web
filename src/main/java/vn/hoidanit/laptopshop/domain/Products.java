package vn.hoidanit.laptopshop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private  int id ;
     private  String name ;
     private String age;
    public Products(int id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public Products(){
        
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Products [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

     
}
