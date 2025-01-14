package com.ApnaMart.ApnaMart.Service;

import com.ApnaMart.ApnaMart.Model.Review;
import com.ApnaMart.ApnaMart.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Review AddReview(Review review){
        return reviewRepository.save(review);
    }
}
