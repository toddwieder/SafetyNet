package com.openclassrooms.projects.safetynet.domain.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Persons by station number dto.
 */
@Getter
@Setter
public class PersonsByStationNumberDto {
	private Long numberOfAdults;

	private Long numberOfChildren;

	private List<PersonInfoDto> persons;

	/**
	 * Instantiates a new Persons by station number dto.
	 */
	public PersonsByStationNumberDto() {
		// parameterless constructor for code coverage// parameterless constructor for code
		// coverage
	}
}
