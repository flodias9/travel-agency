package com.floriandias.travelagency.travelagency.controller;

import java.util.List;

import com.floriandias.travelagency.travelagency.model.Booking;
import com.floriandias.travelagency.travelagency.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping(value = "/{id}")
    public Booking getBooking(@PathVariable("id") Long id) {
        return bookingRepository.getById(id);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookings = bookingRepository.findAll();
        return ResponseEntity.ok()
        .body(bookings);
    }

    @PostMapping
    public Booking saveClient(@RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        bookingRepository.deleteById(id);
    }
}
