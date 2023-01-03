package com.svalero.cybershop.service;

import com.svalero.cybershop.domain.Client;
import com.svalero.cybershop.domain.Discount;

import java.util.List;

public interface DiscountService {

    List<Discount> findAll();

    Discount findByEvent(String event);

    Discount addDiscount(Discount discount);
}
