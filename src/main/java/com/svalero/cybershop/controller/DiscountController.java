package com.svalero.cybershop.controller;

import com.svalero.cybershop.domain.Discount;
import com.svalero.cybershop.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @GetMapping("/discounts")
    public List<Discount> getDiscount(){
        return discountService.findAll();
    }

    @GetMapping("/discounts/{id}")
    public ResponseEntity<Discount> getDiscount(@PathVariable long id){
       Discount discount = discountService.findById(id);
       return ResponseEntity.ok(discount);
    }

    @PostMapping("/discounts")
    public void addDiscount(@RequestBody Discount discount){
        discountService.addDiscount(discount);
    }

    @DeleteMapping("discounts/{id}")
    public void deleteDiscount(@PathVariable long id){
        discountService.deleteDiscount(id);
    }

    @PutMapping("/discounts/{id}")
    public Discount updateDiscount(@PathVariable long id, @RequestBody Discount discount){
        return discountService.updateDiscount(id, discount);
    }

}
