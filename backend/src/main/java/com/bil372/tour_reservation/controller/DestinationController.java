package com.bil372.tour_reservation.controller;

import com.bil372.tour_reservation.entity.Destination;
import com.bil372.tour_reservation.service.DestinationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    // 1) Ülke listesi
    // GET /api/countries
    @GetMapping("/countries")
    public List<String> getCountries() {
        return destinationService.getAllCountries();
    }

    // 2) Belirli ülkeye ait destinasyonlar
    // GET /api/destinations/by-country/{country}
    @GetMapping("/destinations/by-country/{country}")
    public List<Destination> getDestinationsByCountry(@PathVariable("country") String country) {
        return destinationService.getDestinationsByCountry(country);
    }

}
