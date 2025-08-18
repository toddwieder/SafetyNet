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
	@NotBlank(message = "First Name is Required.")
	private String firstName;

	@NotBlank(message = "Last Name is Required.")
	private String lastName;

	@NotBlank(message = "Address is Required.")
	private String address;

	@NotBlank(message = "City is Required.")
	private String city;

	private String zip;

	@NotBlank(message = "Phone is Required.")
	private String phone;

	@NotBlank(message = "Email is Required.")
	private String email;

	/**
	 * Instantiates a new Person dto.
	 */
	public PersonDto() {
		// parameterless constructor for code coverage// parameterless constructor for code
		// coverage
	}
}
