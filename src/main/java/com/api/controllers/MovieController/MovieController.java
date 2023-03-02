package com.api.controllers.MovieController;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.models.entities.Movie.Movie;
import com.api.models.responses.RestResponse.RestResponse;
import com.api.services.MovieService.IMovieService;

@RestController
public class MovieController {
	
	private IMovieService movieService;
	
	public MovieController(IMovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping("/movie")
	@ResponseBody
	public RestResponse getMovies(@RequestParam(required = false, defaultValue = "false") boolean withCast) {
		RestResponse response;
		if(withCast) {
			List<Object> movies = this.movieService.getAllMoviesWithCast();
			response = new RestResponse(movies);
		}else {
			List<Movie> movies = this.movieService.getAllMovies();
			response = new RestResponse(movies);
		}
		return response;
	}
	
}
