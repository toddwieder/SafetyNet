package com.openclassrooms.projects.safetynet.repository;

import com.openclassrooms.projects.safetynet.domain.interfaces.DataContext;
import com.openclassrooms.projects.safetynet.domain.model.Person;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * The type Safety net repository.
 */
@Repository
public class SafetyNetRepositoryImpl implements SafetyNetRepository {
	/**
	 * The constant AGE_OF_ADULTHOOD.
	 */
// region fields
	public static final int AGE_OF_ADULTHOOD = 18;

	private final DataContext context;
	//endregion

	/**
	 * Instantiates a new Safety net repository.
	 *
	 * @param context the context
	 */
// region constructors
	@Autowired
	public SafetyNetRepositoryImpl(final DataContext context) {
		this.context = context;
	}
// endregion

	// region public methods
	@Override
	public List<Person> getChildrenByAddress(final String address) {
		return context.persons()
		                   .filter(p -> p.getAddress().equals(address) && p.getHouseholdMembers()
		                                                                   .stream()
		                                                                   .anyMatch(m -> AGE_OF_ADULTHOOD >= m.getAge()))
		                   .toList();
	}

	@Override
	public List<String> getEmailAddressesByCity(final String city) {
		return context.persons().filter(p -> p.getCity().equals(city)).map(Person::getEmail)
		                   .toList();
	}

	@Override
	public Map<Integer, Map<String, List<Person>>> getHouseholdsByFirestations(final List<Integer> stationNumbers) {
		return context.persons().filter(p -> stationNumbers.contains(p.getFirestationNumber()))
		                   .collect(Collectors.groupingBy(Person::getFirestationNumber,
				                   Collectors.groupingBy(Person::getAddress)));
	}

	@Override
	public List<Person> getPersonsAndFirestationByAddress(final String address) {
		return context.persons().filter(p -> p.getAddress().equals(address)).toList();
	}

	@Override
	public List<Person> getPersonsByLastName(final String lastName) {
		return context.persons().filter(p -> p.getLastName().equals(lastName)).toList();
	}

	@Override
	public List<Person> getPersonsByStationNumber(final int stationNumber) {
		return context.persons().filter(p -> p.getFirestationNumber().equals(stationNumber))
		                   .toList();
	}

	@Override
	public List<String> getPhoneNumbersByStationNumber(final int stationNumber) {
		return context.persons().filter(p -> p.getFirestationNumber().equals(stationNumber))
		                   .map(Person::getPhone).distinct().toList();
	}
// endregion
}

