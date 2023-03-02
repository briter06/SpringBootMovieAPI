package com.api.controllers.MovieController;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.entities.Movie.Movie;
import com.api.models.responses.RestResponse.RestResponse;
import com.api.services.MapperService.IMapperService;
import com.api.services.MovieService.IMovieService;

@RestController
public class MovieController {
	
	private IMapperService mapperService;
	private IMovieService movieService;
	
	public MovieController(IMapperService mapperService, IMovieService movieService) {
		this.mapperService = mapperService;
		this.movieService = movieService;
	}
	
	@GetMapping("/")
	@ResponseBody
	public RestResponse getMovies() {
		List<Movie> movies = this.movieService.getAllMovies();
		RestResponse response = new RestResponse(movies);
		return response;
	}
	
}
