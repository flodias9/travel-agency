package com.floriandias.travelagency.travelagency.controller;

import java.util.List;

import com.floriandias.travelagency.travelagency.model.Step;
import com.floriandias.travelagency.travelagency.repository.StepRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/step")
public class StepController {
    @Autowired
    private StepRepository stepRepository;

    @GetMapping(value = "/{id}")
    public Step getStep(@PathVariable("id") Long id) {
        return stepRepository.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<Step>> getAllSteps() {
        List<Step> steps = stepRepository.findAll();
        return ResponseEntity.ok()
        .body(steps);
    }

    @PostMapping
    public Step saveClient(@RequestBody Step step) {
        return stepRepository.save(step);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        stepRepository.deleteById(id);
    }
}
