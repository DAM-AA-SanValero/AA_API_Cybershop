package com.svalero.cybershop.service;

import com.svalero.cybershop.domain.Client;
import com.svalero.cybershop.domain.Product;
import com.svalero.cybershop.exception.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(long id) throws ProductNotFoundException;

    Product addProduct(Product product);

    void deleteProduct(long id) throws ProductNotFoundException;

    Product updateProduct(long id, Product product) throws ProductNotFoundException;
}

