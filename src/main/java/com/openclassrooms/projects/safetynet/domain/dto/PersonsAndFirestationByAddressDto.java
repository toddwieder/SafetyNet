package com.openclassrooms.projects.safetynet.domain.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonsAndFirestationByAddressDto {
	private Integer firestationNumber;
	private List<PersonInfoDto> residents;

	public PersonsAndFirestationByAddressDto(Integer firestationNumber) {
		this.firestationNumber = firestationNumber;
	}
}
