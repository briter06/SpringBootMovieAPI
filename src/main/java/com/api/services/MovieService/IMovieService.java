package com.api.services.MovieService;

import java.util.List;

import com.api.models.entities.Movie.Movie;

public interface IMovieService {
	
	List<Movie> getAllMovies();
	
	List<Object> getAllMoviesWithCast();
	
}
