package com.openclassrooms.projects.safetynet.tests.api;

import com.openclassrooms.projects.safetynet.api.SafetyNetApi;
import com.openclassrooms.projects.safetynet.domain.dto.ChildrenByAddressDto;
import com.openclassrooms.projects.safetynet.domain.dto.HouseholdByFirestationDto;
import com.openclassrooms.projects.safetynet.domain.dto.HouseholdsByAddressDto;
import com.openclassrooms.projects.safetynet.domain.dto.PersonInfoDto;
import com.openclassrooms.projects.safetynet.domain.dto.PersonsAndFirestationByAddressDto;
import com.openclassrooms.projects.safetynet.domain.dto.PersonsByStationNumberDto;
import com.openclassrooms.projects.safetynet.service.SafetyNetService;
import com.openclassrooms.projects.safetynet.tests.TestHelper;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
class SafetyNetApiTest {
	@Mock
	private SafetyNetService service;

	@InjectMocks
	private SafetyNetApi api;

	@Test
	void getChildrenByAddressTest() {
		var people = TestHelper.getArrayWithOnePersonInfoDto();
		var childrenByAddress = new ChildrenByAddressDto(people, people);
		when(this.service.getChildrenByAddress(anyString())).thenReturn(childrenByAddress);
		var result = this.api.getChildrenByAddress("123 Main Street");
		assertNotNull(result);
		assertNotNull(result.getBody());
		assertEquals(1, ((ChildrenByAddressDto)result.getBody()).getChildren().size());
	}

	@Test
	void getEmailAddressesByCityTest() {
		when(this.service.getEmailAddressesByCity(anyString())).thenReturn(List.of("jdoe@test" + ".com"));
		var result = this.api.getEmailAddressesByCity("New York");
		assertNotNull(result);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertNotNull(result.getBody());
		assertEquals(1, ((Collection<String>) result.getBody()).size());
	}

	@Test
	void getHouseholdsByFirestationsTest() {
		var expected= new HouseholdByFirestationDto(1);
		expected.setHouseholds(List.of(new HouseholdsByAddressDto("123 Main St", TestHelper.getArrayWithOnePersonInfoDto())));
		when(this.service.getHouseholdsByFirestations(List.of(1,2,3))).thenReturn(List.of(expected));
		var actual = this.api.getHouseholdsByFirestations(List.of(1,2,3));
		assertNotNull(actual);
		assertEquals(HttpStatus.OK, actual.getStatusCode());
		assertNotNull(actual.getBody());
		assertEquals(1, ((Collection<HouseholdByFirestationDto>) actual.getBody()).size());
	}



	@Test
	void getPersonsAndFirestationByAddressTest() {
		var expected = new PersonsAndFirestationByAddressDto(1);
		expected.setResidents(TestHelper.getArrayWithOnePersonInfoDto());
		when(this.service.getPersonsAndFirestationByAddress("123 Main Street")).thenReturn(expected);
		var actual = this.api.getPersonsAndFirestationByAddress("123 Main Street");
		assertNotNull(actual);
		assertEquals(HttpStatus.OK, actual.getStatusCode());
		assertNotNull(actual.getBody());
		assertEquals(1 ,((PersonsAndFirestationByAddressDto)actual.getBody()).getResidents().size());
		assertEquals(1 ,((PersonsAndFirestationByAddressDto)actual.getBody()).getFirestationNumber());
	}

	@Test
	void getPersonsByLastNameTest() {
		var expected = TestHelper.getArrayWithOnePersonInfoDto();
		when(this.service.getPersonsByLastName(anyString())).thenReturn(expected);
		var actual = this.api.getPersonsByLastName("Smith");
		assertEquals(HttpStatus.OK, actual.getStatusCode());
		assertNotNull(actual.getBody());
		assertEquals(1, ((Collection<PersonInfoDto>) actual.getBody()).size());
	}

	@Test
	void getPersonsByStationNumberTest() {
		var expected = new PersonsByStationNumberDto();
		expected.setPersons(TestHelper.getArrayWithOnePersonInfoDto());
		expected.setNumberOfChildren(1L);
		expected.setNumberOfAdults(2L);
		when(this.service.getPersonsByStationNumber(anyInt())).thenReturn(expected);
		var actual = this.api.getPersonsByStationNumber(1);
		assertEquals(HttpStatus.OK, actual.getStatusCode());
		assertNotNull(actual.getBody());
		assertEquals(2, ((PersonsByStationNumberDto)actual.getBody()).getNumberOfAdults());
		assertEquals(1,((PersonsByStationNumberDto)actual.getBody()).getNumberOfChildren());
	}

	@Test
	void getPhoneNumbersByFirestationTest() {
		when(this.service.getPhoneNumbersByStationNumber(anyInt())).thenReturn(List.of("555-555" +
				"-5555"));
		var actual = this.api.getPhoneNumbersByFirestation(1);
		assertEquals(HttpStatus.OK, actual.getStatusCode());
		assertNotNull(actual.getBody());
		assertEquals(1, ((Collection<String>) actual.getBody()).size());
	}
}