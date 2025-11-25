package com.bil372.tour_reservation.repository;

import com.bil372.tour_reservation.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour, Integer> {

    //Tüm turları getir
    @Query(
        value = "SELECT * FROM Tour",
        nativeQuery = true
    )
    List<Tour> findAllTours();


    // Belirli destinasyondaki turları getir
    @Query(
        value = "SELECT * FROM Tour WHERE destination_id = :destId",
        nativeQuery = true
    )
    List<Tour> findByDestinationId(@Param("destId") Integer destId);


    @Query(
        value = "SELECT * FROM Tour WHERE company_id = :compId",
        nativeQuery = true
    )
    List<Tour> findByCompanyId(@Param("compId") Integer compId);


    @Query(
        value = "SELECT * FROM Tour ORDER BY avg_rating DESC",
        nativeQuery = true
    )
    List<Tour> findTopRatedTours();
    
}
