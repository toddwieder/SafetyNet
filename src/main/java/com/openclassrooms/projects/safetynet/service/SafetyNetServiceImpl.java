package com.openclassrooms.projects.safetynet.service;

import com.openclassrooms.projects.safetynet.domain.dto.ChildrenByAddressDto;
import com.openclassrooms.projects.safetynet.domain.dto.HouseholdByFirestationDto;
import com.openclassrooms.projects.safetynet.domain.dto.HouseholdsByAddressDto;
import com.openclassrooms.projects.safetynet.domain.dto.PersonInfoDto;
import com.openclassrooms.projects.safetynet.domain.dto.PersonsAndFirestationByAddressDto;
import com.openclassrooms.projects.safetynet.domain.dto.PersonsByStationNumberDto;
import com.openclassrooms.projects.safetynet.domain.mapper.SafetyNetApiMapper;
import com.openclassrooms.projects.safetynet.repository.SafetyNetRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Safety net service.
 */
@Service
public class SafetyNetServiceImpl implements SafetyNetService {
	/**
	 * The constant AGE_OF_ADULTHOOD.
	 */
// region fields
	public static final int AGE_OF_ADULTHOOD = 18;

	private final SafetyNetRepository repository;

	/**
	 * Instantiates a new Safety net service.
	 *
	 * @param repository the repository
	 */
	@Autowired
	public SafetyNetServiceImpl(final SafetyNetRepository repository) {
		this.repository = repository;
	}

	@Override
	public ChildrenByAddressDto getChildrenByAddress(final String address) {
		final var persons = repository.getChildrenByAddress(address);
		return new ChildrenByAddressDto(persons.stream().filter(p -> AGE_OF_ADULTHOOD >= p.getAge())
		                                       .map(SafetyNetApiMapper::toChildrenByAddressChildrenDto)
		                                       .toList(), persons.stream()
		                                                         .filter(p -> AGE_OF_ADULTHOOD < p.getAge())
		                                                         .map(SafetyNetApiMapper::toChildrenByAddressAdultDto)
		                                                         .toList());
	}

	@Override
	public List<String> getEmailAddressesByCity(final String city) {
		return repository.getEmailAddressesByCity(city);
	}

	@Override
	public List<HouseholdByFirestationDto> getHouseholdsByFirestations(final List<Integer> stationNumbers) {
		final var householdMap = repository.getHouseholdsByFirestations(stationNumbers);
		final List<HouseholdByFirestationDto> response = new ArrayList<>();
		householdMap.forEach((firestationNumber, personsByAddress) -> {
			final var firestation = new HouseholdByFirestationDto(firestationNumber);
			personsByAddress.forEach((address, persons) -> firestation.getAddresses()
			                                                          .add(new HouseholdsByAddressDto(address, persons.stream()
			                                                                                                          .map(SafetyNetApiMapper::toResidentsByAddressPersonDto)
			                                                                                                          .toList())));
			response.add(firestation);
		});
		return response;
	}

	@Override
	public PersonsAndFirestationByAddressDto getPersonsAndFirestationByAddress(final String address) {
		final var persons = repository.getPersonsAndFirestationByAddress(address);
		final var response = new PersonsAndFirestationByAddressDto(persons.getFirst()
		                                                                  .getFirestationNumber());
		response.setResidents(persons.stream()
		                             .map(SafetyNetApiMapper::toResidentsByAddressPersonDto)
		                             .toList());
		return response;
	}

	@Override
	public List<PersonInfoDto> getPersonsByLastName(final String lastName) {
		final var persons = repository.getPersonsByLastName(lastName);
		return persons.stream().map(SafetyNetApiMapper::toResidentsByAddressPersonDto).toList();
	}

	@Override
	public PersonsByStationNumberDto getPersonsByStationNumber(final int stationNumber) {
		final var persons = repository.getPersonsByStationNumber(stationNumber);
		final var response = new PersonsByStationNumberDto();
		response.setPersons(persons.stream()
		                           .map(SafetyNetApiMapper::toPersonsByStationNumberDtoPersonDto)
		                           .toList());
		response.setNumberOfAdults(persons.stream().filter(p -> AGE_OF_ADULTHOOD < p.getAge())
		                                  .count());
		response.setNumberOfChildren(response.getPersons().size() - response.getNumberOfAdults());
		return response;
	}

	@Override
	public List<String> getPhoneNumbersByStationNumber(final int stationNumber) {
		return repository.getPhoneNumbersByStationNumber(stationNumber);
	}
}
