package com.api.models.entities.Movie;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class MovieSerializer extends StdSerializer<Movie>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MovieSerializer() {
        this(null);
    }
  
    public MovieSerializer(Class<Movie> t) {
        super(t);
    }

	@Override
	public void serialize(Movie value, JsonGenerator gen, SerializerProvider provider) throws IOException {
		// TODO Auto-generated method stub
		gen.writeStartObject();
		gen.writeNumberField("id", value.getId());
		gen.writeStringField("title", value.getTitle());
		gen.writeStringField("releaseDate", value.getReleaseDate());
		gen.writeNumberField("rating", value.getRating());
		gen.writeEndObject();
	}
	
}
