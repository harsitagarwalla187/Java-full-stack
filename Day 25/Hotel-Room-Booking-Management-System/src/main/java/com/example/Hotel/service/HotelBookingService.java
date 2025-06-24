package com.example.Hotel.service;

import com.example.Hotel.entity.HotelBooking;
import com.example.Hotel.repository.HotelBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelBookingService {

    @Autowired
    HotelBookingRepository hotelRepo;

    public void bookRoom(HotelBooking room) {
        hotelRepo.save(room);
    }

    public List<HotelBooking> allBooking() {
        return hotelRepo.findAll();
    }

    public List<HotelBooking> findByType(String type) {
        return hotelRepo.findByType(type);
    }

    public HotelBooking findByName(String name) {
        return hotelRepo.findByName(name);
    }

    public List<HotelBooking> findByNameStartsWith(char s) {
        return hotelRepo.findByNameStartingWith(s);
    }

    public int countByCity(String city) {
        return hotelRepo.countByCity(city);
    }

    public void deleteBookingById(Long id) {
        hotelRepo.deleteById(id);
    }
}
