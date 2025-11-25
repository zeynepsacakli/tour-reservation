package com.bil372.tour_reservation.service;

import com.bil372.tour_reservation.entity.TourPackage;
import com.bil372.tour_reservation.repository.TourPackageRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TourPackageService {

    private final TourPackageRepository tourPackageRepository;

    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    public List<TourPackage> getPackagesByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return tourPackageRepository.findPackagesInPriceRange(minPrice, maxPrice);
    }

    public List<TourPackage> getPackagesOrderByPriceAsc() {
        return tourPackageRepository.findPackageOrderByPriceAsc();
    }

    public List<TourPackage> getPackagesOrderByPriceDesc() {
        return tourPackageRepository.findPackageOrderByPriceDesc();
    }

    public List<TourPackage> getPackagesByDateRange(java.time.LocalDate startDate, java.time.LocalDate endDate) {
        return tourPackageRepository.findPackagesByDateRange(startDate, endDate);
    }
}