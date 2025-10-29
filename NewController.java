package org.example.productservice.controller;


import org.example.productservice.model.Product;
import org.example.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pruducts")
public class NewController{
    // repository
    private final ProductRepository productRepository;

    public NewController(ProductRepository productRepository) {
        this.productRepository= productRepository;
    }


    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        Product p = productRepository.findById(id).orElse(null);
        return p;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product p = productRepository.save(product);
        return ResponseEntity.ok(p);
    }



}