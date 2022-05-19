package com.floriandias.travelagency.travelagency.repository;

import com.floriandias.travelagency.travelagency.model.Place;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository <Place, Long> {
    
}
