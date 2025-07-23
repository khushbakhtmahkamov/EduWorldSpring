package com.example.eduworldspring.controller;
import com.example.eduworldspring.model.Rating;
import com.example.eduworldspring.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public Rating create(@RequestBody Rating rating) {
        return ratingService.createRating(rating);
    }

    @GetMapping("/{id}")
    public Rating get(@PathVariable Long id) {
        return ratingService.getRatingById(id);
    }

    @GetMapping
    public List<Rating> getAll() {
        return ratingService.getAllRatings();
    }

    @PutMapping("/{id}")
    public Rating update(@PathVariable Long id, @RequestBody Rating rating) {
        return ratingService.updateRating(id, rating);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ratingService.deleteRating(id);
    }
}
