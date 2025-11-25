package com.bil372.tour_reservation.service;

import com.bil372.tour_reservation.entity.Tour;
import com.bil372.tour_reservation.repository.TourRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourService {

    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }
    
    public List<Tour> getAllTours() {
        return tourRepository.findAllTours();
    }

    public List<Tour> getToursByDestination(Integer destId)  {
        return tourRepository.findByDestinationId(destId);
    }

    public List<Tour> getToursByCompany(Integer compId)  {
        return tourRepository.findByCompanyId(compId);
    }

    public List<Tour> getTopRatedTours() {
        return tourRepository.findTopRatedTours();
    }

    

}
