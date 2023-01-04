package com.svalero.cybershop.controller;

import com.svalero.cybershop.domain.Client;
import com.svalero.cybershop.exception.ClientNotFoundException;
import com.svalero.cybershop.exception.ErrorMessage;
import com.svalero.cybershop.service.ClientService;
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
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    public List<Client> getClient(){
        return clientService.findAll();

    }

    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable long id) throws ClientNotFoundException{
        return clientService.findById(id);
    }

    @PostMapping("/clients")
    public void addClient(@RequestBody Client client){
        clientService.addClient(client);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable long id) throws ClientNotFoundException{
        clientService.deleteClient(id);
    }

    @PutMapping("/clients/{id}")
    public Client updateClient(@PathVariable long id, @RequestBody Client client) throws ClientNotFoundException {
        return clientService.updateClient(id, client);
    }

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErrorMessage> clientNotFoundException(ClientNotFoundException cnfe){
        ErrorMessage notfound = new ErrorMessage(404,cnfe.getMessage());
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
