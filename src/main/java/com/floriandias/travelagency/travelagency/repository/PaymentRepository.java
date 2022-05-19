package com.floriandias.travelagency.travelagency.repository;

import com.floriandias.travelagency.travelagency.model.Payment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository <Payment, Long> {
    
}
