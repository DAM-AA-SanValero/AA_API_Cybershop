package com.svalero.cybershop.service;

import com.svalero.cybershop.domain.Client;
import com.svalero.cybershop.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findByName(String name);

    Product addProduct(Product product);
}

