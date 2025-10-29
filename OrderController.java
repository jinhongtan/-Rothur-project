package org.example.productservice.controller;


import org.example.productservice.model.Product;
import org.example.productservice.repository.ProductRepository;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/proudcts")
public class OrderController{
    private final ProductRepository productRepository;

    public OrderController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/{id}")
    public List<Product> getProductById(@PathVariable Long id){
        List<Product> product_list = productRepository.findAll();
        return product_list;
    }

    @GetMapping
    public List<Product> getAllProduct(){
        List<Product> product_list = productRepository.findAll();
        return product_list;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword,@RequestParam int id){
        List<Product> product_list = productRepository.findAll();

        List<Product> result = product_list.stream().filter(product -> product.getId() == id).collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        productRepository.save(product);
        return ResponseEntity.ok(product);
    }

}