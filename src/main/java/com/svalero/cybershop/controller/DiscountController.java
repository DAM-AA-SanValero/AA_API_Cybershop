package com.svalero.cybershop.controller;

import com.svalero.cybershop.domain.Discount;
import com.svalero.cybershop.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @GetMapping("/discounts")
    public List<Discount> getDiscount(){
        return discountService.findAll();
    }

    @PostMapping("/discounts")
    public void addDiscount(@RequestBody Discount discount){
        discountService.addDiscount(discount);
    }

}
