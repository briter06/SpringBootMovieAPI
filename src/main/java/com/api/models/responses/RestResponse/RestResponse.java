package com.api.models.responses.RestResponse;

import java.util.List;

public class RestResponse {

	public Object data;
	public List<String> errors;
	
	public RestResponse(Object data) {
		this.data = data;
	}
}
