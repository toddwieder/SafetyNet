package com.openclassrooms.projects.safetynet.service;

import com.openclassrooms.projects.safetynet.domain.dto.ChildrenByAddressDto;
import com.openclassrooms.projects.safetynet.domain.dto.HouseholdByFirestationDto;
import com.openclassrooms.projects.safetynet.domain.dto.PersonInfoDto;
import com.openclassrooms.projects.safetynet.domain.dto.PersonsAndFirestationByAddressDto;
import com.openclassrooms.projects.safetynet.domain.dto.PersonsByStationNumberDto;
import java.util.List;

/**
 * The interface Safety net service.
 */
public interface SafetyNetService {
	/**
	 * Gets children by address.
	 *
	 * @param address the address
	 * @return the children by address
	 */
	ChildrenByAddressDto getChildrenByAddress(String address);

	/**
	 * Gets email addresses by city.
	 *
	 * @param city the city
	 * @return the email addresses by city
	 */
	List<String> getEmailAddressesByCity(String city);

	/**
	 * Gets households by firestations.
	 *
	 * @param stationNumbers the station numbers
	 * @return the households by firestations
	 */
	List<HouseholdByFirestationDto> getHouseholdsByFirestations(List<Integer> stationNumbers);

	/**
	 * Gets persons and firestation by address.
	 *
	 * @param address the address
	 * @return the persons and firestation by address
	 */
	PersonsAndFirestationByAddressDto getPersonsAndFirestationByAddress(String address);

	/**
	 * Gets persons by last name.
	 *
	 * @param lastName the last name
	 * @return the persons by last name
	 */
	List<PersonInfoDto> getPersonsByLastName(String lastName);

	/**
	 * Gets persons by station number.
	 *
	 * @param stationNumber the station number
	 * @return the persons by station number
	 */
	PersonsByStationNumberDto getPersonsByStationNumber(int stationNumber);

	/**
	 * Gets phone numbers by station number.
	 *
	 * @param stationNumber the station number
	 * @return the phone numbers by station number
	 */
	List<String> getPhoneNumbersByStationNumber(int stationNumber);

}
