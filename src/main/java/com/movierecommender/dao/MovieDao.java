package com.movierecommender.dao;



import java.util.List;
import java.util.Optional;

import com.movierecommender.model.Movie;

public interface MovieDao {
  
  Optional<Movie> getMovieById(int id);
  
  List<Movie> getRandomMovies(int num);

  List<Movie> getRandomPopularMovies(int num);
}

