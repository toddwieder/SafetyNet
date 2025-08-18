package com.openclassrooms.projects.safetynet.domain.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Household by firestation dto.
 */
@Getter
@Setter
public class HouseholdByFirestationDto {

	private List<HouseholdsByAddressDto> addresses = new ArrayList<>();
	private final Integer firestationNumber;
	private List<HouseholdsByAddressDto> households= new ArrayList<>();

	/**
	 * Instantiates a new Household by firestation dto.
	 *
	 * @param firestationNumber the firestation number
	 */
	public HouseholdByFirestationDto(Integer firestationNumber) {
		this.firestationNumber = firestationNumber;
	}
}
