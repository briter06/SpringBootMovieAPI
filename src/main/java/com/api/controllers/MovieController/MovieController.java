package com.api.controllers.MovieController;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.entities.Movie.Movie;
import com.api.models.responses.RestResponse.RestResponse;
import com.api.services.MapperService.IMapperService;

@RestController
public class MovieController {
	
	private IMapperService mapperService;
	
	public MovieController(IMapperService mapperService) {
		this.mapperService = mapperService;
	}
	
	@GetMapping("/")
	@ResponseBody
	public RestResponse getMovies() {
		Movie newMovie = new Movie(1, "Toy Story", "2000-01-01", 9.5);
		Movie[] movTemp = {newMovie};
		List<Movie> movies = Arrays.asList(movTemp);
		RestResponse response = new RestResponse(movies);
		return response;
	}
	
}
