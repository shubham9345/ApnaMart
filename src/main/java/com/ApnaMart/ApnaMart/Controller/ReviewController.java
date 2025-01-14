package com.ApnaMart.ApnaMart.Controller;

import com.ApnaMart.ApnaMart.Model.Review;
import com.ApnaMart.ApnaMart.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/Review")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping("/Add-Review")
    public Review AddReview(@RequestBody Review reviews) {

        return reviewService.AddReview(reviews);
    }
}
