package com.openclassrooms.projects.safetynet.domain.dto.crud;

import com.openclassrooms.projects.safetynet.domain.interfaces.CrudDto;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FirestationDto implements CrudDto {
// region fields
	private String address;
	private Integer station;
//endregion

	public FirestationDto() {
		// parameterless constructor for code coverage
	}
}
