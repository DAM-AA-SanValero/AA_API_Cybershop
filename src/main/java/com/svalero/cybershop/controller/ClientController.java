package com.svalero.cybershop.controller;

import com.svalero.cybershop.domain.Client;
import com.svalero.cybershop.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    ClientService clientService;

    @GetMapping("/clients")
    public List<Client> getClient(){
        return clientService.findAll();

    }

    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable long id){
        return clientService.findById(id);
    }

    @PostMapping("/clients")
    public void addClient(@RequestBody Client client){
        clientService.addClient(client);
    }

}
