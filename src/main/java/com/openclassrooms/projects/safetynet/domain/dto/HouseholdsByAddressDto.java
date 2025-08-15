package com.openclassrooms.projects.safetynet.domain.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseholdsByAddressDto {
	private String address;
	private List<PersonInfoDto> persons;

	public HouseholdsByAddressDto(String address, List<PersonInfoDto> persons) {
		this.address = address;
		this.persons = persons;
	}
}
