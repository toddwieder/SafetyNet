package com.openclassrooms.projects.safetynet.domain.dto.crud;

import com.openclassrooms.projects.safetynet.domain.interfaces.CrudDto;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Firestation dto.
 */
@Setter
@Getter
public class FirestationDto implements CrudDto {

	@NotBlank(message = "Address is Required.")
	private String address;

	@NotBlank(message = "Station is Required.")
	private Integer station;

	/**
	 * Instantiates a new Firestation dto.
	 */
	public FirestationDto() {
		// parameterless constructor for code coverage
	}
}
