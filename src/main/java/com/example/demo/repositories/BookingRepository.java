package com.example.demo.repositories;

import com.example.demo.moduls.Booking_;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking_,Integer> {
}
