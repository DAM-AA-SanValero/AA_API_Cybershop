package com.svalero.cybershop.exception;

public class RepairNotFoundException extends Exception{
    public RepairNotFoundException() {
        super("Client not found");
    }
    public RepairNotFoundException(String message){
        super(message);
    }

}
