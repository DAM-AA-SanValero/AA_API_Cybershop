package com.svalero.cybershop.service;

import com.svalero.cybershop.domain.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAll();
    Client findById(long id);

    Client addClient(Client client);

    void deleteClient(long id);

    Client updateClient(long id, Client updateClient);

}
