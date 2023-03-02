package com.api.models.entities.Movie;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = MovieSerializer.class)
public class Movie {

	private int id;
	private String title;
	private String releaseDate;
	private double rating;
	
	public Movie(int id, String title, String releaseDate, double rating) {
		this.id = id;
		this.title = title;
		this.releaseDate = releaseDate;
		this.rating = rating;
	}
	
	int getId() {
		return this.id;
	}
	
	String getTitle() {
		return this.title;
	}
	
	String getReleaseDate() {
		return this.releaseDate;
	}
	
	double getRating() {
		return this.rating;
	}
	
}
