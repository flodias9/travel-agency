package com.floriandias.travelagency.travelagency.repository;

import com.floriandias.travelagency.travelagency.model.Booking;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository <Booking, Long> {
    
}
