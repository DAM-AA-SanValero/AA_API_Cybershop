package com.svalero.cybershop.controller;

import com.svalero.cybershop.domain.Client;
import com.svalero.cybershop.domain.Product;
import com.svalero.cybershop.service.ClientService;
import com.svalero.cybershop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<Product> getClient(){
        return productService.findAll();
    }

    @GetMapping("/products/{id}")
    public Product getClient(@PathVariable long id){
        return productService.findById(id);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }

}
