package com.api.services.RandomDataService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.api.models.objects.CastMember.CastMember;
import com.api.services.ConfigService.ConfigService;
import com.api.services.MapperService.IMapperService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

@Service
public class RandomDataService implements IRandomDataService{
	
	private ConfigService configService;
	private IMapperService mapperService;
	
	public RandomDataService(ConfigService configService, IMapperService mapperService) {
		this.configService = configService;
		this.mapperService = mapperService;
	}

	
	public List<CastMember> getRandomCastMembers(int numberOfMembers) {
		RestTemplate restTemplate = new RestTemplate();
		String url = String.format("%s/users?size=%s&response_type=json", this.configService.getAppConfig().randomDataApiUrl, numberOfMembers);
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		ArrayNode responseObject = this.mapperService.stringToArrayNode(response.getBody());
		List<CastMember> members = new ArrayList<CastMember>();
		if(responseObject.isArray()) {
			for (JsonNode randomPerson: responseObject) {
				Long id = randomPerson.get("id").asLong();
				String name = String.format("%s %s", randomPerson.get("first_name").asText(), randomPerson.get("last_name").asText());
				Date dateOfBirth = new Date();
				try {
					dateOfBirth = new SimpleDateFormat("YYYY-MM-DD").parse(randomPerson.get("date_of_birth").asText());
				} catch (ParseException e) {}
				String secondaryJob = randomPerson.get("employment").get("title").asText();
				CastMember newMember = new CastMember(id, name, dateOfBirth, secondaryJob);
				members.add(newMember);
			}
		}
		return members;
	}
	
}
