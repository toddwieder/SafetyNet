package com.openclassrooms.projects.safetynet.domain.dto.crud;

import com.openclassrooms.projects.safetynet.domain.interfaces.CrudDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDto implements CrudDto {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String zip;
	private String phone;
	private String email;

	public PersonDto() {
		// parameterless constructor for code coverage// parameterless constructor for code coverage
	}
}
