package com.openclassrooms.projects.safetynet.domain.mapper;

import com.openclassrooms.projects.safetynet.domain.dto.PersonInfoDto;
import com.openclassrooms.projects.safetynet.domain.model.Person;
import com.openclassrooms.projects.safetynet.domain.utility.ModelHelper;

public enum SafetyNetApiMapper {
	;

	public static PersonInfoDto toPersonsByStationNumberDtoPersonDto(Person person) {
		return new PersonInfoDto(person.getFirstName(), person.getLastName(), person.getAddress(),
				person.getPhone());
	}

	public static PersonInfoDto toChildrenByAddressChildrenDto(Person person) {
		return new PersonInfoDto(person.getFirstName(), person.getLastName(), person.getAge());
	}

	public static PersonInfoDto toChildrenByAddressAdultDto(Person person) {
		return new PersonInfoDto(ModelHelper.getFullName(person));
	}

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
