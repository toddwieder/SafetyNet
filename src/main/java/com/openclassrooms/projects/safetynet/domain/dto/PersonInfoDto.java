package com.openclassrooms.projects.safetynet.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.openclassrooms.projects.safetynet.domain.model.Medication;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonInfoDto {
	// region fields
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String address;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer age;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<String> allergies;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String emailAddress;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String firstName;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String fullName;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<PersonInfoDto> householdMembers;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String lastName;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Medication> medications;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String name;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String phoneNumber;
	// endregion

	//region constructors
	public PersonInfoDto(String firstName, String lastName, String address, String phoneNumber) {
		this(firstName, lastName, null, address, phoneNumber, null, null, null, null, null);
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public PersonInfoDto(String firstName, String lastName, Integer age,
	                     List<PersonInfoDto> householdMembers) {
		this(firstName, lastName, null, null, null, null, age, null, null, householdMembers);
	}

	public PersonInfoDto(String firstName, String lastName, List<String> allergies,
	                     List<Medication> medications) {
		this(firstName, lastName, null, null, null, null, null, allergies, medications, null);

	}

	public PersonInfoDto(String fullName) {
		this.fullName = fullName;
	}

	public PersonInfoDto(String fullName, String phone, Integer age, List<String> allergies,
	                     List<Medication> medications) {
		this(null, null, fullName, null, phone, null, age, allergies, medications, null);
	}

	public PersonInfoDto(String firstName, String lastName) {
		this(firstName, lastName, null, null, null, null, null, null, null, null);
	}

	public PersonInfoDto(String firstName, String lastName, Integer age) {
		this(firstName, lastName, null, null, null, null, age, null, null, null);
	}

	public PersonInfoDto(String fullName, String address, Integer age, String email,
	                     List<String> allergies, List<Medication> medications) {
		this(null, null, fullName, address, null, email, age, allergies, medications, null);
	}
	public PersonInfoDto(String firstName, String lastName, String fullName, String address,
	                     String phoneNumber, String emailAddress, Integer age,
	                     List<String> allergies, List<Medication> medications,
	                     List<PersonInfoDto> householdMembers) {
		this.address = address;
		this.age = age;
		this.allergies = allergies;
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.fullName = fullName;
		this.householdMembers = householdMembers;
		this.lastName = lastName;
		this.medications = medications;
		this.phoneNumber = phoneNumber;
	}
// endregion

}
