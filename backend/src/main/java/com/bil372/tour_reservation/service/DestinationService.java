package com.bil372.tour_reservation.service;

import com.bil372.tour_reservation.entity.Destination;
import com.bil372.tour_reservation.repository.DestinationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public List<String> getAllCountries() {
        return destinationRepository.findDistinctCountries();
    }

    public List<Destination> getDestinationsByCountry(String country) {
        return destinationRepository.findByDestinationCountryOrderByDestinationCityAsc(country);
    }
}
