package com.bil372.tour_reservation.controller;

import com.bil372.tour_reservation.entity.Tour;
import com.bil372.tour_reservation.service.TourService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
public class TourController {

    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public List<Tour> getAllTours() {
        return tourService.getAllTours();
    }


    @GetMapping("/by-destination/{destinationId}")
    public List<Tour> getToursByDestination(@PathVariable("destinationId") Integer destinationId) {
        return tourService.getToursByDestination(destinationId);
    }

    @GetMapping("/by-company/{companyId}")
    public List<Tour> getToursByCompany(@PathVariable("companyId") Integer companyId) {
        return tourService.getToursByCompany(companyId);
    }

    @GetMapping("/top-rated")
    public List<Tour> getTopRatedTours() {
        return tourService.getTopRatedTours();
    }
}
