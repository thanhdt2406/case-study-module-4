package com.codegym.casestudy4.service.rating;

import com.codegym.casestudy4.model.AppUser;
import com.codegym.casestudy4.model.Rating;
import com.codegym.casestudy4.repo.IRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingServiceImpl implements IRatingService {
    @Autowired
    private IRatingRepository ratingRepository;

    @Override
    public Iterable<Rating> findAll() {
        return null;
    }

    @Override
    public Optional<Rating> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Rating save(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Rating findByProduct_ProductIdAndAppUser(Long id, AppUser appUser) {
        return ratingRepository.findByProduct_ProductIdAndAppUser(id, appUser);
    }

    @Override
    public Double findAvgRatingByProductId(Long id) {
        if(ratingRepository.findAvgRatingByProductId(id)==null){
            return 0D;
        }
        else return ratingRepository.findAvgRatingByProductId(id);
    }

    @Override
    public Iterable<Rating> findAllByProduct_ProductId(Long id) {
        return ratingRepository.findAllByProduct_ProductId(id);
    }
}
