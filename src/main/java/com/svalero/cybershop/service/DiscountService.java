package com.svalero.cybershop.service;

import com.svalero.cybershop.domain.Client;
import com.svalero.cybershop.domain.Discount;

import java.util.List;

public interface DiscountService {

    List<Discount> findAll();

    Discount findById(long id);

    Discount addDiscount(Discount discount);

    void deleteDiscount(long id);
    Discount updateDiscount(long id, Discount discount);
}
