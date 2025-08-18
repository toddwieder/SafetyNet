package com.openclassrooms.projects.safetynet.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.openclassrooms.projects.safetynet.domain.model.Medication;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Person info dto.
 */
@Getter
@Setter
public class PersonInfoDto {
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

	/**
	 * Instantiates a new Person info dto.
	 *
	 * @param firstName   the first name
	 * @param lastName    the last name
	 * @param address     the address
	 * @param phoneNumber the phone number
	 */
	public PersonInfoDto(String firstName, String lastName, String address, String phoneNumber) {
		this(firstName, lastName, null, address, phoneNumber, null, null, null, null, null);
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Instantiates a new Person info dto.
	 *
	 * @param fullName the full name
	 */
	public PersonInfoDto(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * Instantiates a new Person info dto.
	 *
	 * @param fullName    the full name
	 * @param phone       the phone
	 * @param age         the age
	 * @param allergies   the allergies
	 * @param medications the medications
	 */
	public PersonInfoDto(String fullName, String phone, Integer age, List<String> allergies,
	                     List<Medication> medications) {
		this(null, null, fullName, null, phone, null, age, allergies, medications, null);
	}

	/**
	 * Instantiates a new Person info dto.
	 *
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @param age       the age
	 */
	public PersonInfoDto(String firstName, String lastName, Integer age) {
		this(firstName, lastName, null, null, null, null, age, null, null, null);
	}

	/**
	 * Instantiates a new Person info dto.
	 *
	 * @param firstName        the first name
	 * @param lastName         the last name
	 * @param fullName         the full name
	 * @param address          the address
	 * @param phoneNumber      the phone number
	 * @param emailAddress     the email address
	 * @param age              the age
	 * @param allergies        the allergies
	 * @param medications      the medications
	 * @param householdMembers the household members
	 */
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
}
