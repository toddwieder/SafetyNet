package com.openclassrooms.projects.safetynet.data.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.openclassrooms.projects.safetynet.domain.model.Firestation;
import com.openclassrooms.projects.safetynet.domain.model.MedicalRecord;
import com.openclassrooms.projects.safetynet.domain.model.Person;
import com.openclassrooms.projects.safetynet.domain.model.SafetyNetData;
import java.util.List;
import org.springframework.boot.jackson.JsonMixin;

/**
 * The type Safety net data mixin.
 */
@JsonMixin(SafetyNetData.class)
public class SafetyNetDataMixin {
	/**
	 * The Firestations.
	 */
	public List<Firestation> firestations;

	/**
	 * The Medical records.
	 */
	@JsonProperty("medicalrecords")
	public List<MedicalRecord> medicalRecords;

	/**
	 * The Persons.
	 */
	public List<Person> persons;
}
