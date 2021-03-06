package com.movierecommender.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.movierecommender.dto.RatingCreationDto;
import com.movierecommender.model.Movie;
import com.movierecommender.model.Rating;
import com.movierecommender.service.MovieService;
import com.movierecommender.service.RatingService;


@Controller
public class MovieController {
  
  private final MovieService movieService;
  private final RatingService ratingService;
  
  @Autowired
  public MovieController(MovieService movieService, RatingService ratingService) {
	this.movieService = movieService;
    this.ratingService = ratingService;
  }
  
  @GetMapping("/")
  public String landing() {
    return "redirect:rate";
  }
  
  @GetMapping("/rate")
  public String rateRandomMovies(Model model) {
    boolean myBooleanVariable = true;
    List<Movie> randomMovies = movieService.getRandomPopularMovies(20);
    RatingCreationDto ratingCreationDto = new RatingCreationDto();
    ratingCreationDto.addEmptyRatings(randomMovies.size());
    List<Rating> ratings = ratingCreationDto.getRatings();
    for (int i = 0; i < randomMovies.size(); i++) {
      ratings.get(i).setMovieId(randomMovies.get(i).getId());
    }
    model.addAttribute("form", ratingCreationDto);
    model.addAttribute("movies", randomMovies);
    model.addAttribute("myBooleanVariable", myBooleanVariable);
    return "rate";
  }
  
  @PostMapping("/recommendation")
  public String getSubmittedRatings(@ModelAttribute RatingCreationDto form, Model model) {
    List<Rating> ratings = form.getRatings();
    ratings = ratingService.filterZeroRating(ratings);
    ratingService.Normalization(ratings);
    if (ratings.size() < 1) {
      model.addAttribute("error", "At least one rating has to be submitted.");
      return "rate";
    }
    List<Integer> recommendedMovieIds = ratingService.getRecommendedMovieIds(ratings);
    List<Movie> recommendedMovies = movieService.getRecommendedMovies(recommendedMovieIds);
    model.addAttribute("ratings", ratings);
    model.addAttribute("movies", recommendedMovies);
    return "recommendation";
  }
  
  
}
