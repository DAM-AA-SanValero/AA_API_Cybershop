package com.svalero.cybershop.service;

import com.svalero.cybershop.domain.Client;
import com.svalero.cybershop.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(long id);

    Product addProduct(Product product);

    void deleteProduct(long id);

    Product updateProduct(long id, Product product);
}

