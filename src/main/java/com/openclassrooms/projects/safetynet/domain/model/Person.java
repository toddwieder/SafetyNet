package com.openclassrooms.projects.safetynet.domain.model;

import com.openclassrooms.projects.safetynet.domain.interfaces.FirstLastName;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Person implements FirstLastName {

// region fields
	private String address;
	private Integer age = -1;
	private String city;
	private String email;
	private Integer firestationNumber = -1;
	private String firstName;
	private List<Person> householdMembers;
	private String lastName;
	private MedicalRecord medicalRecord;
	private String phone;
	private String zip;
//endregion

// region constructors
	public Person(String firstName, String lastName, String address, String city, String zip,
	              String phone, String email, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.phone = phone;
		this.email = email;
		this.age = age;
	}

	public Person() {
	}
// endregion
}
