package com.svalero.cybershop.controller;

import com.svalero.cybershop.domain.Discount;
import com.svalero.cybershop.exception.DiscountNotFoundException;
import com.svalero.cybershop.exception.ErrorMessage;
import com.svalero.cybershop.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @GetMapping("/discounts")
    public List<Discount> getDiscount(){
        return discountService.findAll();
    }

    @GetMapping("/discounts/{id}")
    public ResponseEntity<Discount> getDiscount(@PathVariable long id) throws DiscountNotFoundException{
       Discount discount = discountService.findById(id);
       return ResponseEntity.ok(discount);
    }

    @PostMapping("/discounts")
    public void addDiscount(@RequestBody Discount discount){
        discountService.addDiscount(discount);
    }

    @DeleteMapping("discounts/{id}")
    public void deleteDiscount(@PathVariable long id) throws DiscountNotFoundException{
        discountService.deleteDiscount(id);
    }

    @PutMapping("/discounts/{id}")
    public Discount updateDiscount(@PathVariable long id, @RequestBody Discount discount) throws DiscountNotFoundException{
        return discountService.updateDiscount(id, discount);
    }

    @ExceptionHandler(DiscountNotFoundException.class)
    public ResponseEntity<ErrorMessage> clientNotFoundException(DiscountNotFoundException dnfe){
        ErrorMessage notfound = new ErrorMessage(404,dnfe.getMessage());
        return new ResponseEntity<>(notfound, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> badRequestException(MethodArgumentNotValidException manve){

        //Indicar en que campo ha fallado el cliente
        Map<String, String> errors = new HashMap<>();
        manve.getBindingResult().getAllErrors().forEach(error -> {
            String fieldname = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldname, message);
        });

        ErrorMessage badRequest = new ErrorMessage(400, "Bad Request", errors);
        return new ResponseEntity<>(badRequest, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception e) {
        ErrorMessage errorMessage = new ErrorMessage(500, "Internal Server Error");
        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
