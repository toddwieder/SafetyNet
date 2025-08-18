package com.openclassrooms.projects.safetynet.domain.mapper;

import com.openclassrooms.projects.safetynet.domain.dto.PersonInfoDto;
import com.openclassrooms.projects.safetynet.domain.model.Person;
import com.openclassrooms.projects.safetynet.domain.utility.ModelHelper;

/**
 * The enum Safety net api mapper.
 */
public enum SafetyNetApiMapper {
	;

	/**
	 * To persons by station number dto person dto person info dto.
	 *
	 * @param person the person
	 * @return the person info dto
	 */
	public static PersonInfoDto toPersonsByStationNumberDtoPersonDto(Person person) {
		return new PersonInfoDto(person.getFirstName(), person.getLastName(), person.getAddress(),
				person.getPhone());
	}

	/**
	 * To children by address children dto person info dto.
	 *
	 * @param person the person
	 * @return the person info dto
	 */
	public static PersonInfoDto toChildrenByAddressChildrenDto(Person person) {
		return new PersonInfoDto(person.getFirstName(), person.getLastName(), person.getAge());
	}

	/**
	 * To children by address adult dto person info dto.
	 *
	 * @param person the person
	 * @return the person info dto
	 */
	public static PersonInfoDto toChildrenByAddressAdultDto(Person person) {
		return new PersonInfoDto(ModelHelper.getFullName(person));
	}

	/**
	 * To residents by address person dto person info dto.
	 *
	 * @param person the person
	 * @return the person info dto
	 */
	public static PersonInfoDto toResidentsByAddressPersonDto(Person person) {
		return new PersonInfoDto(
				ModelHelper.getFullName(person),
				person.getPhone(),
				person.getAge(),
				person.getMedicalRecord() == null ? null :
				person.getMedicalRecord().getAllergies(),
				person.getMedicalRecord() == null ? null :
				person.getMedicalRecord().getMedications());
	}
}
