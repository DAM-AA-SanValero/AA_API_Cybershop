package com.svalero.cybershop.exception;

public class ProductNotFoundException extends Exception{
    public ProductNotFoundException() {
        super("Client not found");
    }
    public ProductNotFoundException(String message){
        super(message);
    }

}
