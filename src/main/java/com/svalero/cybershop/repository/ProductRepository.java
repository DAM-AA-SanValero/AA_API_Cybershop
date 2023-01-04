package com.svalero.cybershop.repository;

import com.svalero.cybershop.domain.Client;
import com.svalero.cybershop.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();
}
