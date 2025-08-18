package com.openclassrooms.projects.safetynet.domain.dto.crud;

import com.openclassrooms.projects.safetynet.domain.interfaces.CrudDto;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Person dto.
 */
@Getter
@Setter
public class PersonDto implements CrudDto {
	private String firstName;

	@NotBlank(message = "Last Name is Required.")
	private String lastName;

	private String address;

	private String city;

	private String zip;

	private String phone;

	private String email;

	/**
	 * Instantiates a new Person dto.
	 */
	public PersonDto() {
		// parameterless constructor for code coverage// parameterless constructor for code
		// coverage
	}
}
