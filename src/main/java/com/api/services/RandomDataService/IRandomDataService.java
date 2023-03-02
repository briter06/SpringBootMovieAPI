package com.api.services.RandomDataService;

import java.util.List;

import com.api.models.objects.CastMember.CastMember;

public interface IRandomDataService {
	
	List<CastMember> getRandomCastMembers(int numberOfMembers);
	
}
