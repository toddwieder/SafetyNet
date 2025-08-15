package com.openclassrooms.projects.safetynet.domain.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonsByStationNumberDto {
	private List<PersonInfoDto> persons;
	private Long numberOfAdults;
	private Long numberOfChildren;

	public PersonsByStationNumberDto() {
		// parameterless constructor for code coverage// parameterless constructor for code coverage
	}
}
