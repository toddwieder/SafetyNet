package com.openclassrooms.projects.safetynet.tests.service;
import com.openclassrooms.projects.safetynet.repository.SafetyNetRepositoryImpl;
import com.openclassrooms.projects.safetynet.service.SafetyNetServiceImpl;
import com.openclassrooms.projects.safetynet.tests.TestHelper;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SafetyNetServiceImplTest {
	@Mock
	private SafetyNetRepositoryImpl repository;

	@InjectMocks
	private SafetyNetServiceImpl service;

	@Test
	void getPersonsByStationNumberTest() {
		when(this.repository.getPersonsByStationNumber(anyInt())).thenReturn(TestHelper.getArrayWithTwoPeople());
		var actual = this.service.getPersonsByStationNumber(1);
		assertNotNull(actual);
		assertEquals(2, actual.getPersons().size());
	}

	@Test
	void getPhoneNumbersByStationNumberTest() {
		when(this.repository.getPhoneNumbersByStationNumber(anyInt())).thenReturn(List.of("555" + "-555-5555"));
		var actual= this.service.getPhoneNumbersByStationNumber(1);
		assertNotNull(actual);
		assertEquals(1, actual.size());
	}

	@Test
	void getChildrenByAddressTest() {
		when(this.repository.getChildrenByAddress(anyString())).thenReturn(TestHelper.getArrayWithTwoPeople());
		var actual = this.service.getChildrenByAddress("123 Main Street");
		assertNotNull(actual);
		assertEquals(1, actual.getChildren().size());
	}

	@Test
	void getHouseholdsByFirestationsTest() {
		when(this.repository.getHouseholdsByFirestations(Arrays.asList(1,2,3))).thenReturn(TestHelper.getFirestationHouseholds());
		var actual = this.service.getHouseholdsByFirestations(Arrays.asList(1,2,3));
		assertNotNull(actual);
		assertEquals(1, actual.size());
	}

	@Test
	void getPersonsAndFirestationByAddressTest() {
		when(this.repository.getPersonsAndFirestationByAddress(anyString())).thenReturn(TestHelper.getArrayWithOnePerson());
		var actual = this.service.getPersonsAndFirestationByAddress("123 Main Street");
		assertNotNull(actual);
		assertEquals(1, actual.getResidents().size());
	}

	@Test
	void getEmailAddressesByCityTest() {
		when(this.repository.getEmailAddressesByCity(anyString()))
				.thenReturn(List.of("jdoe@mail.com"));
		var actual = this.service.getEmailAddressesByCity("New York");
		assertNotNull(actual);
		assertEquals(1, actual.size());
		assert actual.getFirst().equals("jdoe@mail.com");
	}

	@Test
	void getPersonsByLastNameTest() {
		when(this.repository.getPersonsByLastName(anyString())).thenReturn(TestHelper.getArrayWithTwoPeople());
		var actual = this.service.getPersonsByLastName("jdoe");
		assertNotNull(actual);
		assertEquals(2, actual.size());
	}
}