package com.svalero.cybershop.service;

import com.svalero.cybershop.domain.Discount;
import com.svalero.cybershop.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    DiscountRepository discountRepository;

    @Override
    public List<Discount> findAll() {
        return discountRepository.findAll();
    }

    @Override
    public Discount findById(long id) {
        return discountRepository.findById(id).orElseThrow();
    }

    @Override
    public Discount addDiscount(Discount discount) {
        return discountRepository.save(discount);
    }

    public void deleteDiscount(long id){
        Discount discount = discountRepository.findById(id).orElseThrow();
        discountRepository.delete(discount);
    }

    @Override
    public Discount updateDiscount(long id, Discount updateDiscount) {
        Discount oldDiscount = discountRepository.findById(id).orElseThrow();
        oldDiscount.setProduct(updateDiscount.getProduct());
        oldDiscount.setEvent(updateDiscount.getEvent());
        oldDiscount.setDiscounted(updateDiscount.getDiscounted());
        oldDiscount.setStartDiscount(updateDiscount.getStartDiscount());
        oldDiscount.setEndDiscount(updateDiscount.getEndDiscount());

        return discountRepository.save(oldDiscount);
    }
}
