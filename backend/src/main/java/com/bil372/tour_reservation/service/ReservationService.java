package com.bil372.tour_reservation.service;

import com.bil372.tour_reservation.entity.Reservation;
import com.bil372.tour_reservation.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getReservationsByUserId(Integer userId) {
        return reservationRepository.findReservationsByUserId(userId);
    }

}