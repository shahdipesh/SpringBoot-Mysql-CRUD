package com.example.demo.Controller;

import com.example.demo.Entity.Product;
import com.example.demo.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ArrayList<Product> getAllProducts(){
        return  productService.getProducts();
    }

    @PostMapping("/saveProduct")
    public Product saveProduct(@RequestBody Product p){
       return productService.saveProduct(p);
    }

    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product p){
        return productService.updateProduct(p);
    }
    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable Integer id){
         productService.removeProduct(id);
    }
}
