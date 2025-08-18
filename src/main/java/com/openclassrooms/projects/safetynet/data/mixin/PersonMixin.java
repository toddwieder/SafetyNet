package com.openclassrooms.projects.safetynet.data.mixin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.openclassrooms.projects.safetynet.domain.model.MedicalRecord;
import com.openclassrooms.projects.safetynet.domain.model.Person;
import java.util.List;

/**
 * The type Person mixin.
 */
public abstract class PersonMixin {
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String zip;
	private String phone;
	private String email;

	@JsonIgnore
	private MedicalRecord medicalRecord;

	@JsonIgnore
	private Integer age;

	@JsonIgnore

	private Integer firestationNumber;

	@JsonIgnore
	private List<Person> householdMembers;
}
