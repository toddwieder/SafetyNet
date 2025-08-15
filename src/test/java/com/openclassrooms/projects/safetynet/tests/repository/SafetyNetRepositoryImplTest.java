package com.openclassrooms.projects.safetynet.tests.repository;

import com.openclassrooms.projects.safetynet.data.FileDataAdapter;
import com.openclassrooms.projects.safetynet.repository.SafetyNetRepositoryImpl;
import com.openclassrooms.projects.safetynet.tests.TestHelper;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;


@ExtendWith(MockitoExtension.class)
class SafetyNetRepositoryImplTest {

	@Mock
	private FileDataAdapter context;

	@InjectMocks
	private SafetyNetRepositoryImpl repository;

	@Test
	void getChildrenByAddressTest() {
		when(this.context.persons()).thenReturn(TestHelper.getArrayWithOnePersonWithHousehold().stream());
		var actual = this.repository.getChildrenByAddress("123 Main St");
		assertNotNull(actual);
		assert(actual.getFirst().getHouseholdMembers().size()==2);
	}

	@Test
	void getPersonsByFirestationTest() {
		when(this.context.persons()).thenReturn(TestHelper.getArrayWithTwoPeople().stream());
		var actual = this.repository.getPersonsByStationNumber(1);
		assertNotNull(actual);
		assert(actual.size()==1);
	}

	@Test
	void getPersonsByLastNameTest() {
		when(this.context.persons()).thenReturn(TestHelper.getArrayWithOnePerson().stream());
		var actual = this.repository.getPersonsByLastName("Doe");
		assertNotNull(actual);
		assert(actual.size()==1);
	}

	@Test
	void getEmailAddressesByCityTest() {
		when(this.context.persons()).thenReturn(TestHelper.getArrayWithTwoPeople().stream());
		var actual= this.repository.getEmailAddressesByCity("New York");
		assertNotNull(actual);
		assert(actual.size()==1);
	}

	@Test
	void getHouseholdsByFirestationsTest() {
		when(this.context.persons()).thenReturn(TestHelper.getArrayWithOnePersonWithHousehold().stream());
		var actual = this.repository.getHouseholdsByFirestations(Arrays.asList(1,2,3));
		assertNotNull(actual);
		assert(actual.size()==1);

	}

	@Test
	void getPhoneNumbersByStationNumberTest() {
		when(this.context.persons()).thenReturn(TestHelper.getArrayWithTwoPeople().stream());
		var actual = this.repository.getPhoneNumbersByStationNumber(1);
		assertNotNull(actual);
		assert(actual.size()==1);
	}

	@Test
	void getPersonsAndFirestationByAddressTest() {
		when(this.context.persons()).thenReturn(TestHelper.getArrayWithOnePersonWithHousehold().stream());
		var actual = this.repository.getPersonsAndFirestationByAddress("123 Main St");
		assertNotNull(actual);
		assert(actual.size()==1);
	}
}