package com.openclassrooms.projects.safetynet.domain.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SafetyNetData {
// region fields
	private List<Firestation> firestations;
	private List<MedicalRecord> medicalRecords;
	private List<Person> persons;
//endregion
}
