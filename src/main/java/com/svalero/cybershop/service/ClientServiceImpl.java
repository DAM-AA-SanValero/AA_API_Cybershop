package com.svalero.cybershop.service;

import com.svalero.cybershop.domain.Client;
import com.svalero.cybershop.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @Override
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(long id) {
        Client client = clientRepository.findById(id).orElseThrow();
        clientRepository.delete(client);
    }

    @Override
    public Client updateClient(long id, Client updateClient) {
        Client oldClient = clientRepository.findById(id).orElseThrow();
        oldClient.setName(updateClient.getName());
        oldClient.setSurname(updateClient.getSurname());
        oldClient.setNumber(updateClient.getNumber());
        oldClient.setRegisterDate(updateClient.getRegisterDate());
        oldClient.setVip(updateClient.isVip());
        return clientRepository.save(oldClient);
    }


}
