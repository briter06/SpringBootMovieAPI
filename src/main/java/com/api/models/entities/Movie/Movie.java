package com.api.models.entities.Movie;

import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity(name = "movies")
@JsonSerialize(using = MovieSerializer.class)
public class Movie {

	@Id
    @SequenceGenerator(name = "movies_sequence", sequenceName = "movies_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movies_sequence")
	private int id;

	@Column(nullable = false, length = 50)
	private String title;

	@Column(nullable = false)
	private Date releaseDate;

	@Column(nullable = false)
	private double rating;
	
	public Movie() {}
	
	public Movie(int id, String title, Date releaseDate, double rating) {
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
	
	Date getReleaseDate() {
		return this.releaseDate;
	}
	
	double getRating() {
		return this.rating;
	}
	
}
