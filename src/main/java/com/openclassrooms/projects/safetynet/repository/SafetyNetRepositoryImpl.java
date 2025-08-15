package com.openclassrooms.projects.safetynet.repository;

import com.openclassrooms.projects.safetynet.domain.interfaces.DataContext;
import com.openclassrooms.projects.safetynet.domain.model.Person;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SafetyNetRepositoryImpl implements SafetyNetRepository {
// region fields
	private final DataContext context;
	public static final int AGE_OF_ADULTHOOD = 18;
	//endregion

// region constructors
	@Autowired
	public SafetyNetRepositoryImpl(DataContext context) {
		this.context = context;
	}
// endregion

// region public methods
	@Override
	public List<Person> getChildrenByAddress(String address) {
		return this.context.persons()
		                   .filter(p -> p.getAddress().equals(address) && p.getHouseholdMembers()
		                                                              .stream()
		                                                              .anyMatch(m -> m.getAge() <= AGE_OF_ADULTHOOD))
		                   .toList();
	}

	@Override
	public List<String> getEmailAddressesByCity(String city) {
		return this.context.persons().filter(p -> p.getCity().equals(city)).map(Person::getEmail)
		                   .toList();
	}

	@Override
	public Map<Integer, Map<String, List<Person>>> getHouseholdsByFirestations(List<Integer> stationNumbers) {
		return this.context.persons().filter(p -> stationNumbers.contains(p.getFirestationNumber()))
		                   .collect(Collectors.groupingBy(Person::getFirestationNumber,
				              Collectors.groupingBy(Person::getAddress)));
	}

	@Override
	public List<Person> getPersonsAndFirestationByAddress(String address) {
		return this.context.persons().filter(p -> p.getAddress().equals(address)).toList();
	}

	@Override
	public List<Person> getPersonsByLastName(String lastName) {
		return this.context.persons().filter(p -> p.getLastName().equals(lastName)).toList();
	}

	@Override
	public List<Person> getPersonsByStationNumber(int stationNumber) {
		return this.context.persons().filter(p -> p.getFirestationNumber().equals(stationNumber))
		                   .toList();
	}

	@Override
	public List<String> getPhoneNumbersByStationNumber(int stationNumber) {
		return this.context.persons().filter(p -> p.getFirestationNumber().equals(stationNumber))
		                   .map(Person::getPhone).distinct().toList();
	}
// endregion
}

