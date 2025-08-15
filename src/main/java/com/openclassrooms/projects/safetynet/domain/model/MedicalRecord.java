package com.openclassrooms.projects.safetynet.domain.model;

import com.openclassrooms.projects.safetynet.domain.interfaces.FirstLastName;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicalRecord implements FirstLastName {
// region fields
	private List<String> allergies = new ArrayList<>();
	private Date birthdate = new Date(0);
	private String firstName;
	private String lastName;
	private List<Medication> medications = new ArrayList<>();
//endregion

// region constructors
	public MedicalRecord(String firstName, String lastName, Date birthdate,
	                     List<Medication> medications, List<String> allergies) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.medications = medications;
		this.allergies = allergies;
	}

	public MedicalRecord() {
	}
// endregion
}
