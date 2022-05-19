package com.floriandias.travelagency.travelagency.controller;

import java.util.List;

import com.floriandias.travelagency.travelagency.model.Client;
import com.floriandias.travelagency.travelagency.repository.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(value = "/{id}")
    public Client getClient(@PathVariable("id") Long id) {
        return clientRepository.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClient() {
        List<Client> clients = clientRepository.findAll();
        return ResponseEntity.ok()
        .body(clients);
    }

    @PostMapping
    public Client saveClient(@Validated @RequestBody Client client) {
        return clientRepository.save(client);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        clientRepository.deleteById(id);
    }
}
