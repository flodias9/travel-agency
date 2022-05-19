package com.floriandias.travelagency.travelagency.controller;

import java.util.List;

import com.floriandias.travelagency.travelagency.model.Tour;
import com.floriandias.travelagency.travelagency.repository.TourRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class TourController {
    @Autowired
    private TourRepository tourRepository;

    @GetMapping(value = "/{id}")
    public Tour getTour(@PathVariable("id") Long id) {
        return tourRepository.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<Tour>> getAllTours() {
        List<Tour> tours = tourRepository.findAll();
        return ResponseEntity.ok()
        .body(tours);
    }

    @PostMapping
    public Tour saveClient(@RequestBody Tour tour) {
        return tourRepository.save(tour);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        tourRepository.deleteById(id);
    }
}
