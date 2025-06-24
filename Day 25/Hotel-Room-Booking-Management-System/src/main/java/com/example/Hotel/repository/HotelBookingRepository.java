package com.example.Hotel.repository;

import com.example.Hotel.entity.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelBookingRepository extends JpaRepository<HotelBooking, Long> {

    HotelBooking findByName(String name);

    List<HotelBooking> findByNameStartingWith(char s);

    List<HotelBooking> findByType(String type);

    int countByCity(String city);
}
