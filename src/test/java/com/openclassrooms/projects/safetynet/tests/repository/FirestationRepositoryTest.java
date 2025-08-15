package com.openclassrooms.projects.safetynet.tests.repository;

import com.openclassrooms.projects.safetynet.domain.model.Firestation;
import com.openclassrooms.projects.safetynet.data.FileDataAdapter;
import com.openclassrooms.projects.safetynet.repository.crud.FirestationRepository;
import com.openclassrooms.projects.safetynet.tests.TestHelper;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FirestationRepositoryTest {
	@Mock
	private FileDataAdapter context;

	@InjectMocks
	private FirestationRepository repository;


	@Test
	void saveTest() {
		when(this.context.saveChanges()).thenReturn(Boolean.TRUE);
		var actual = this.repository.save();
		assertTrue(actual);
	}

	@Test
	void addTest() {
		when(this.context.addFirestation(any(Firestation.class))).thenAnswer(i -> i.getArgument(0));
		var actual = this.repository.add(TestHelper.getFirestation());
		assertNotNull(actual);
	}

	@Test
	void deleteTest() {
		when(this.context.deleteFirestation(any(Firestation.class))).thenReturn(true);
		var actual = this.context.deleteFirestation(TestHelper.getFirestation());
		assertTrue(actual);
	}

	@Test
	void getTest() {
		when(this.context.getFirestation(any(Firestation.class))).thenReturn(TestHelper.getFirestation());
		var firestation = new Firestation();
		firestation.setStation(1);
		var actual = this.repository.get(firestation);
		assertEquals(1, actual.getStation());
	}

	@Test
	void getAllTest() {
		when(this.context.firestations()).thenReturn(TestHelper.getArrayWithTwoFirestations().stream());
		var actual = this.repository.getAll();
		assertEquals(2,actual.size());
	}

	@Test
	void updateTest() {
		when(this.context.getFirestation(any(Firestation.class))).thenReturn(TestHelper.getFirestation());
		when(this.context.updateFirestation(any(Firestation.class))).thenAnswer(i -> i.getArgument(0));
		var firestation = TestHelper.getFirestation();
		firestation.setAddress("555 New St");
		var actual = this.repository.update(firestation);
		assertEquals("555 New St", actual.getAddress());
	}
}