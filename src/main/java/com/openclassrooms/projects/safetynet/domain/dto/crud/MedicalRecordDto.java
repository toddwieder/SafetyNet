package com.openclassrooms.projects.safetynet.domain.dto.crud;

import com.openclassrooms.projects.safetynet.domain.interfaces.CrudDto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicalRecordDto implements CrudDto {
	private String firstName;
	private String lastName;
	private Date birthdate;
	private List<MedicationDto> medications = new ArrayList<>();
	private List<String> allergies = new  ArrayList<>();

	public MedicalRecordDto() {
		// parameterless constructor for code coverage
	}
}
