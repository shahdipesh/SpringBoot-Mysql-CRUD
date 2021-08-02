package com.example.demo.Services;

import com.example.demo.Entity.Product;
import com.example.demo.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ArrayList<Product> getProducts(){
        return productRepository.getAllProducts();

    }

    public Product saveProduct(Product p){
        return productRepository.saveAndFlush(p);
    }

    public void removeProduct(Integer id){
        System.out.println("------ID-----"+id);
        Optional<Product> productToDelete = productRepository.findById(id);
        if(productToDelete!=null){
            productRepository.deleteById(id);
        }
    }


    public Product updateProduct(Product productToSave){
        if(productToSave.getId()==null){
            return null;
        }
        Product existingProduct = productRepository.getProductById(productToSave.getId());
        if(existingProduct!=null){
            if(productToSave.getName()!=null) {
              existingProduct.setName(productToSave.getName());
            }
            if(productToSave.getPrice()!=null) {
                existingProduct.setPrice(productToSave.getPrice());
            }
            if(productToSave.getQuantity()!=null) {
                existingProduct.setQuantity(productToSave.getQuantity());
            }
            System.out.println("UPDATING============>>");
            return productRepository.saveAndFlush(existingProduct);
        }
        else{
            return null;
        }
    }


}
