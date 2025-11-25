package com.bil372.tour_reservation.controller;

import com.bil372.tour_reservation.entity.TourPackage;
import com.bil372.tour_reservation.service.TourPackageService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/tour-packages")
@CrossOrigin(origins = "*")
public class TourPackageController {

    private final TourPackageService tourPackageService;

    public TourPackageController(TourPackageService tourPackageService){
        this.tourPackageService = tourPackageService;
    }

    @GetMapping("/by-price-range")
    public List<TourPackage> getPackagesByPriceRange(@RequestParam("min") BigDecimal minPrice,
                                                     @RequestParam("max") BigDecimal maxPrice) {
        return tourPackageService.getPackagesByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/order-by-price-asc")
    public List<TourPackage> getPackagesOrderByPriceAsc() {
        return tourPackageService.getPackagesOrderByPriceAsc();
    }

    @GetMapping("/order-by-price-desc")
    public List<TourPackage> getPackagesOrderByPriceDesc() {
        return tourPackageService.getPackagesOrderByPriceDesc();    
    }

    @GetMapping("/by-date-range")
    public List<TourPackage> getPackagesByDateRange(@RequestParam("start") String startDate,
                                                    @RequestParam("end") String endDate) {
        return tourPackageService.getPackagesByDateRange(java.time.LocalDate.parse(startDate), java.time.LocalDate.parse(endDate));
    }
}
