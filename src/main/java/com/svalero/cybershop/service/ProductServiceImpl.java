package com.svalero.cybershop.service;

import com.svalero.cybershop.domain.Client;
import com.svalero.cybershop.domain.Product;
import com.svalero.cybershop.repository.ClientRepository;
import com.svalero.cybershop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(long id) {
        return productRepository.findById(id).orElseThrow();
    }
    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(long id) {
        Product product = productRepository.findById(id).orElseThrow();
    }

    @Override
    public Product updateProduct(long id, Product updateProduct) {
        Product oldProduct = productRepository.findById(id).orElseThrow();
        oldProduct.setName(updateProduct.getName());
        oldProduct.setType(updateProduct.getType());
        oldProduct.setPrice(updateProduct.getPrice());
        oldProduct.setOrigin(updateProduct.getOrigin());
        oldProduct.setInStock(updateProduct.isInStock());

        return productRepository.save(oldProduct);
    }


}
