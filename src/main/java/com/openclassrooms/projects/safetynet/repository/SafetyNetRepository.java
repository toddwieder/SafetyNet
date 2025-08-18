package com.openclassrooms.projects.safetynet.repository;

import com.openclassrooms.projects.safetynet.domain.model.Person;
import java.util.List;
import java.util.Map;

/**
 * The interface Safety net repository.
 */
public interface SafetyNetRepository {
	/**
	 * Gets children by address.
	 *
	 * @param address the address
	 * @return the children by address
	 */
	List<Person> getChildrenByAddress(String address);

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
	Map<Integer, Map<String, List<Person>>> getHouseholdsByFirestations(List<Integer> stationNumbers);

	/**
	 * Gets persons and firestation by address.
	 *
	 * @param address the address
	 * @return the persons and firestation by address
	 */
	List<Person> getPersonsAndFirestationByAddress(String address);

	/**
	 * Gets persons by last name.
	 *
	 * @param lastName the last name
	 * @return the persons by last name
	 */
	List<Person> getPersonsByLastName(String lastName);

	/**
	 * Gets persons by station number.
	 *
	 * @param stationNumber the station number
	 * @return the persons by station number
	 */
	List<Person> getPersonsByStationNumber(int stationNumber);

	/**
	 * Gets phone numbers by station number.
	 *
	 * @param stationNumber the station number
	 * @return the phone numbers by station number
	 */
	List<String> getPhoneNumbersByStationNumber(int stationNumber);
}