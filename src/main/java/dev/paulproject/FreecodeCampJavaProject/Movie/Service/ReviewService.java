package dev.paulproject.FreecodeCampJavaProject.Movie.Service;

import dev.paulproject.FreecodeCampJavaProject.Movie.Model.Movie;
import dev.paulproject.FreecodeCampJavaProject.Movie.Model.Reviews;
import dev.paulproject.FreecodeCampJavaProject.Movie.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public Reviews create(String reviewBody, String id){
        Reviews review = new Reviews(reviewBody);
        reviewRepository.insert(review);
        mongoTemplate.update(Movie.class).matching(Criteria.where("id").is(id)).apply(new Update().push("reviewIds").value(review));
        return review;
    }
}
