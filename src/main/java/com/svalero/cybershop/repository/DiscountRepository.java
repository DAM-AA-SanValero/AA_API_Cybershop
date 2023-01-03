package com.svalero.cybershop.repository;

import com.svalero.cybershop.domain.Discount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepository extends CrudRepository<Discount, Long> {

    List<Discount> findAll();

    Discount findByEvent(String event);


}
