package com.floriandias.travelagency.travelagency.controller;

import java.util.List;

import com.floriandias.travelagency.travelagency.model.Place;
import com.floriandias.travelagency.travelagency.repository.PlaceRepository;

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
@RequestMapping("/place")
public class PlaceController {
    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping(value = "/{id}")
    public Place getPlace(@PathVariable("id") Long id) {
        return placeRepository.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<Place>> getAllPlaces() {
        List<Place> places = placeRepository.findAll();
        return ResponseEntity.ok()
        .body(places);
    }

    @PostMapping
    public Place saveClient(@RequestBody Place place) {
        return placeRepository.save(place);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        placeRepository.deleteById(id);
    }
}
