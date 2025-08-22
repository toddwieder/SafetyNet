package com.openclassrooms.projects.safetynet.domain.dto.crud;

import com.openclassrooms.projects.safetynet.domain.interfaces.CrudDto;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Medical record dto.
 */
@Getter
@Setter
public class MedicalRecordDto implements CrudDto {
	@NotBlank(message = "First Name is Required.")
	private String firstName;

	@NotBlank(message = "Last Name is Required.")
	private String lastName;

	@NotBlank(message = "Birthdate is Required.")
	private Date birthdate;

	private List<MedicationDto> medications = new ArrayList<>();

	private List<String> allergies = new ArrayList<>();

	/**
	 * Instantiates a new Medical record dto.
	 */
	public MedicalRecordDto() {
		// parameterless constructor for code coverage
	}
}
