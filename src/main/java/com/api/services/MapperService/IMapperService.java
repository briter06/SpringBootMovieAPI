package com.api.services.MapperService;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public interface IMapperService {
	ObjectMapper getMapper();
	ObjectNode createObjectNode();
	ObjectNode stringToObjectNode(String jsonString);
	ObjectNode serializeObject(Object object);
	<T> ArrayNode serializeArray(List<T> list);
	ArrayNode stringToArrayNode(String jsonString);
}
