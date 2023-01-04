package com.svalero.cybershop.controller;

import com.svalero.cybershop.domain.Client;
import com.svalero.cybershop.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable long id){
        clientService.deleteClient(id);
    }

    @PutMapping("/clients/{id}")
    public Client updateClient(@PathVariable long id, @RequestBody Client client){
        return clientService.updateClient(id, client);
    }

}
