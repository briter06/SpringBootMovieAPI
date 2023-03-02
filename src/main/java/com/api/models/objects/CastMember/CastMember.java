package com.api.models.objects.CastMember;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CastMember {
	
	@JsonProperty
	private Long id;
	
	@JsonProperty
	private String name;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-DD")
	private Date dateOfBirth;
	
	@JsonProperty
	private String secondaryJob;
	
	public CastMember(Long id, String name, Date dateOfBirth, String secondaryJob) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.secondaryJob = secondaryJob;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSecondaryJob() {
		return secondaryJob;
	}

	public void setSecondaryJob(String secondaryJob) {
		this.secondaryJob = secondaryJob;
	}
	
	
	
}
