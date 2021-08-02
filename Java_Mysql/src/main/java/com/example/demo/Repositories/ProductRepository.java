package com.example.demo.Repositories;

import com.example.demo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>,CrudRepository<Product,Integer> {

        @Query(value = "SELECT * FROM product", nativeQuery = true)
        ArrayList<Product> getAllProducts();

        @Query(value = "SELECT * FROM product WHERE id =?1", nativeQuery = true)
        Product getProductById(int id);



}
