package com.api.services.MovieService;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.api.models.entities.Movie.Movie;

@Service
public class MovieService implements IMovieService {

	
	public List<Movie> getAllMovies() {
		Movie newMovie = new Movie(1, "Toy Story", "2000-01-01", 9.5);
		Movie[] movTemp = {newMovie};
		List<Movie> movies = Arrays.asList(movTemp);
		return movies;
	}
	
	
	
}
