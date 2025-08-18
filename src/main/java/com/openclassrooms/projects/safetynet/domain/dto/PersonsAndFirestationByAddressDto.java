package com.openclassrooms.projects.safetynet.domain.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Persons and firestation by address dto.
 */
@Getter
@Setter
public class PersonsAndFirestationByAddressDto {
	private Integer firestationNumber;

	private List<PersonInfoDto> residents;

	/**
	 * Instantiates a new Persons and firestation by address dto.
	 *
	 * @param firestationNumber the firestation number
	 */
	public PersonsAndFirestationByAddressDto(Integer firestationNumber) {
		this.firestationNumber = firestationNumber;
	}
}
