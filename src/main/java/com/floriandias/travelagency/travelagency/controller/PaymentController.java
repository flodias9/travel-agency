package com.floriandias.travelagency.travelagency.controller;

import java.util.List;

import com.floriandias.travelagency.travelagency.model.Payment;
import com.floriandias.travelagency.travelagency.repository.PaymentRepository;

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
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping(value = "/{id}")
    public Payment getPayment(@PathVariable("id") Long id) {
        return paymentRepository.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        List<Payment> payments = paymentRepository.findAll();
        return ResponseEntity.ok()
        .body(payments);
    }

    @PostMapping
    public Payment saveClient(@RequestBody Payment payment) {
        return paymentRepository.save(payment);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        paymentRepository.deleteById(id);
    }
}
