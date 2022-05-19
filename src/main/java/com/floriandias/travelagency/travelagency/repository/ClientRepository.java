package com.floriandias.travelagency.travelagency.repository;

import com.floriandias.travelagency.travelagency.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
