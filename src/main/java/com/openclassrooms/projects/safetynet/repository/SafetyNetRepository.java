package com.openclassrooms.projects.safetynet.repository;

import com.openclassrooms.projects.safetynet.domain.model.Person;
import java.util.List;
import java.util.Map;

public interface SafetyNetRepository {
	List<Person> getChildrenByAddress(String address);

	List<Person> getPersonsByStationNumber(int stationNumber);

	List<Person> getPersonsByLastName(String lastName);

	List<String> getEmailAddressesByCity(String city);

	Map<Integer, Map<String, List<Person>>> getHouseholdsByFirestations(List<Integer> stationNumbers);

	List<String> getPhoneNumbersByStationNumber(int stationNumber);

	List<Person> getPersonsAndFirestationByAddress(String address);
}