package com.openclassrooms.projects.safetynet.tests.service.crud;

import com.openclassrooms.projects.safetynet.domain.dto.crud.FirestationDto;
import com.openclassrooms.projects.safetynet.domain.mapper.FirestationMapper;
import com.openclassrooms.projects.safetynet.domain.model.Firestation;
import com.openclassrooms.projects.safetynet.repository.crud.CrudRepository;
import com.openclassrooms.projects.safetynet.service.crud.FirestationService;
import com.openclassrooms.projects.safetynet.tests.TestHelper;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FirestationServiceTest {
	@Mock
	CrudRepository repository;
	@Spy
	FirestationMapper mapper = new FirestationMapper();

	@InjectMocks
	private FirestationService service;

	@Test
	void getAll() {
		when(this.repository.getAll()).thenReturn(List.of(TestHelper.getFirestation()));
		var result = this.service.getAll();
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	@Test
	void get() {
		var testFirestation = TestHelper.getFirestation();
		when(this.repository.get(any(Firestation.class))).thenReturn(testFirestation);
		var result = this.service.get(new FirestationDto());
		assertNotNull(result);
		assertEquals(testFirestation.getAddress(), result.getAddress());
	}

	@Test
	void add() {
		var testFirestation = TestHelper.getFirestation();
		when(this.repository.add(any(Firestation.class))).thenReturn(testFirestation);
		var result = this.service.add(new FirestationDto());
		assertNotNull(result);
		assertEquals(testFirestation.getAddress(), result.getAddress());
	}

	@Test
	void update() {
		var testFirestation = TestHelper.getFirestation();
		when(this.repository.update(any(Firestation.class))).thenReturn(testFirestation);
		testFirestation.setAddress("Address");
		var result = this.service.update(new FirestationDto());
		assertNotNull(result);
		assertEquals("Address", result.getAddress());
	}

	@Test
	void delete() {
		when(this.repository.delete(any(Firestation.class))).thenReturn(true);
		var result = this.service.delete(new FirestationDto());
		assertNotNull(result);
		assertTrue(result);
	}
}