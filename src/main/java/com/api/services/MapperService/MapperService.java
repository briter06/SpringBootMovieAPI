package com.api.services.MapperService;

import org.springframework.stereotype.Service;

import com.api.models.entities.Movie.Movie;
import com.api.models.entities.Movie.MovieSerializer;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class MapperService implements IMapperService{
	
	private ObjectMapper mapper;
	
	public MapperService() {
		this.mapper = new ObjectMapper();
		SimpleModule module = new SimpleModule("GeneralModule", new Version(1, 0, 0, null, null, null));
		
		// MovieSerializer
		module.addSerializer(Movie.class, new MovieSerializer());
		this.mapper.registerModule(module);
	}

	public ObjectMapper getMapper() {
		return this.mapper;
	}

	public ObjectNode createObjectNode() {
		return this.mapper.createObjectNode();
	}

}
