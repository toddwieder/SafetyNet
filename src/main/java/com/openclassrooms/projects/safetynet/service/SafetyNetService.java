package com.openclassrooms.projects.safetynet.service;

import com.openclassrooms.projects.safetynet.domain.dto.ChildrenByAddressDto;
import com.openclassrooms.projects.safetynet.domain.dto.HouseholdByFirestationDto;
import com.openclassrooms.projects.safetynet.domain.dto.PersonInfoDto;
import com.openclassrooms.projects.safetynet.domain.dto.PersonsAndFirestationByAddressDto;
import com.openclassrooms.projects.safetynet.domain.dto.PersonsByStationNumberDto;
import java.util.List;

public interface SafetyNetService {
	ChildrenByAddressDto getChildrenByAddress(String address);

	List<String> getEmailAddressesByCity(String city);

	List<HouseholdByFirestationDto> getHouseholdsByFirestations(List<Integer> stationNumbers);

	PersonsAndFirestationByAddressDto getPersonsAndFirestationByAddress(String address);

	PersonsByStationNumberDto getPersonsByStationNumber(int stationNumber);

	List<String> getPhoneNumbersByStationNumber(int stationNumber);

	List<PersonInfoDto> getPersonsByLastName(String lastName);

}
