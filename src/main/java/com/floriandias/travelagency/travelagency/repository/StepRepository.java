package com.floriandias.travelagency.travelagency.repository;

import com.floriandias.travelagency.travelagency.model.Step;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StepRepository extends JpaRepository <Step, Long> {
    
}
