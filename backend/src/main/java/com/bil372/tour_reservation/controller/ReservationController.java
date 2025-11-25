package com.bil372.tour_reservation.controller;

import com.bil372.tour_reservation.entity.Reservation;
//import com.bil372.tour_reservation.entity.Review;
import com.bil372.tour_reservation.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@CrossOrigin(origins = "*")

public class ReservationController {
    
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping("/user/{userId}")
    public List<Reservation> getReservationsByUserId(@PathVariable Integer userId) {
        return reservationService.getReservationsByUserId(userId);
    }

}
