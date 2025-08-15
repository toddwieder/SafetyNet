package com.openclassrooms.projects.safetynet.domain.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HouseholdByFirestationDto {
// region fields
	private List<HouseholdsByAddressDto> addresses = new ArrayList<>();
	private final Integer firestationNumber;
	private List<HouseholdsByAddressDto> households= new ArrayList<>();
//endregion

// region constructors
	public HouseholdByFirestationDto(Integer firestationNumber) {
		this.firestationNumber = firestationNumber;
	}
// endregion
}
