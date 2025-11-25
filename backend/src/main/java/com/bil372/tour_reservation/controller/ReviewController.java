package com.bil372.tour_reservation.controller;

//import com.bil372.tour_reservation.entity.Review;
import com.bil372.tour_reservation.service.ReviewService;
import org.springframework.web.bind.annotation.*;

//import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    
}