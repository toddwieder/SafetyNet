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

@Service
public class SafetyNetServiceImpl implements SafetyNetService {
	public static final int AGE_OF_ADULTHOOD = 18;
	private final SafetyNetRepository repository;

	@Autowired
	public SafetyNetServiceImpl(SafetyNetRepository repository) {
		this.repository = repository;
	}

	@Override
	public PersonsByStationNumberDto getPersonsByStationNumber(int stationNumber) {
		var persons= this.repository.getPersonsByStationNumber(stationNumber);
		var response = new PersonsByStationNumberDto();
		response.setPersons(persons.stream()
		                           .map(SafetyNetApiMapper::toPersonsByStationNumberDtoPersonDto)
		                           .toList());
		response.setNumberOfAdults(persons.stream().filter(p -> p.getAge() > AGE_OF_ADULTHOOD).count());
		response.setNumberOfChildren(response.getPersons().size() - response.getNumberOfAdults());
		return response;
	}

	@Override
	public List<String> getPhoneNumbersByStationNumber(int stationNumber) {
		return this.repository.getPhoneNumbersByStationNumber(stationNumber);
	}

	@Override
	public ChildrenByAddressDto getChildrenByAddress(String address) {
		var persons = this.repository.getChildrenByAddress(address);
		return new ChildrenByAddressDto(persons.stream().filter(p -> p.getAge() <= AGE_OF_ADULTHOOD)
		                                               .map(SafetyNetApiMapper::toChildrenByAddressChildrenDto).toList(),
				persons.stream()
				       .filter(p -> p.getAge() > AGE_OF_ADULTHOOD)
				       .map(SafetyNetApiMapper::toChildrenByAddressAdultDto)
				       .toList());
	}

	@Override
	public List<HouseholdByFirestationDto> getHouseholdsByFirestations(List<Integer> stationNumbers) {
		var householdMap = this.repository.getHouseholdsByFirestations(stationNumbers);
		List<HouseholdByFirestationDto> response = new ArrayList<>();
		householdMap.forEach((firestationNumber, personsByAddress) -> {
			var firestation = new HouseholdByFirestationDto(firestationNumber);
			personsByAddress.forEach((address, persons) ->
																			firestation.getAddresses()
																			           .add(new HouseholdsByAddressDto(address, persons.stream()
																			                                                           .map(SafetyNetApiMapper::toResidentsByAddressPersonDto)
																			                                                           .toList())));
			response.add(firestation);
		});
		return response;
	}

	@Override
	public PersonsAndFirestationByAddressDto getPersonsAndFirestationByAddress(String address) {
		var persons = this.repository.getPersonsAndFirestationByAddress(address);
		var response = new PersonsAndFirestationByAddressDto(persons.getFirst()
		                                                            .getFirestationNumber());
		response.setResidents(persons.stream().map(SafetyNetApiMapper::toResidentsByAddressPersonDto).toList());
		return response;
	}

	@Override
	public List<String> getEmailAddressesByCity(String city) {
		return this.repository.getEmailAddressesByCity(city);
	}

	@Override
	public List<PersonInfoDto> getPersonsByLastName(String lastName) {
		var persons = this.repository.getPersonsByLastName(lastName);
		return persons.stream().map(SafetyNetApiMapper::toResidentsByAddressPersonDto).toList();
	}
}
