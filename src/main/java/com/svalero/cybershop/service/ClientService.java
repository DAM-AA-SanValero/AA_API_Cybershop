package com.svalero.cybershop.service;

import com.svalero.cybershop.domain.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAll();
    Client findByName(String name);
}
