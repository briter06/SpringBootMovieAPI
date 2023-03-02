package com.api.services.MapperService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface IMapperService {
	ObjectMapper getMapper();
	ObjectNode createObjectNode();
}
