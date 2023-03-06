package com.api.services.MovieService;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.api.models.entities.Movie.IMovieRepository;
import com.api.models.entities.Movie.Movie;
import com.api.models.objects.CastMember.CastMember;
import com.api.services.MapperService.IMapperService;
import com.api.services.RandomDataService.IRandomDataService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class MovieService implements IMovieService {
	
	private IMapperService mapperService;
	private IRandomDataService randomDataService;
	private IMovieRepository movieRepository;
	
	public MovieService(IMapperService mapperService, IRandomDataService randomDataService, IMovieRepository movieRepository) {
		this.mapperService = mapperService;
		this.randomDataService = randomDataService;
		this.movieRepository = movieRepository;
	}
	
	public List<Movie> getAllMovies() {
		List<Movie> movies = this.movieRepository.findAll();
		return movies;
	}
	
	public List<Object> getAllMoviesWithCast() {
		List<Movie> movies = this.movieRepository.findAll();
		List<Object> newMovies = movies.stream().map(this::addCastToMovie).collect(Collectors.toList());
		return newMovies;
	}
	
	private Object addCastToMovie(Movie movie) {
		ObjectNode newMovie = this.mapperService.serializeObject(movie);
		Random r = new Random();
		List<CastMember> castMembers = this.randomDataService.getRandomCastMembers(r.nextInt(10));
		newMovie.set("cast", this.mapperService.<CastMember>serializeArray(castMembers));
		return newMovie;
	}
	
}
