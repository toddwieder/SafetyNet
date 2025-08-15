package com.openclassrooms.projects.safetynet.tests.api.crud;

import com.openclassrooms.projects.safetynet.api.crud.FirestationController;
import com.openclassrooms.projects.safetynet.domain.dto.crud.FirestationDto;
import com.openclassrooms.projects.safetynet.domain.interfaces.CrudDto;
import com.openclassrooms.projects.safetynet.service.crud.CrudService;
import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.openclassrooms.projects.safetynet.tests.TestHelper;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FirestationControllerTest {
	@Mock
	CrudService service;

	@InjectMocks
	private FirestationController controller;

	@Test
	void add() {
		var firestationDto = TestHelper.getFirestationDto();
		when(this.service.add(any(CrudDto.class))).thenReturn(firestationDto);
		var actual = this.controller.add(firestationDto);
		assertNotNull(actual);
		assertEquals(firestationDto,(FirestationDto)actual.getBody());
	}

	@Test
	void delete() {
		var firestationDto = TestHelper.getFirestationDto();
		when(this.service.delete(any(CrudDto.class))).thenReturn(true);
		var actual = this.controller.delete(firestationDto);
		assertNotNull(actual);
		assertTrue((Boolean)actual.getBody());
	}

	@Test
	void getAll() {
		var firestationDtos = List.of(TestHelper.getFirestationDto());
		when(this.service.getAll()).thenReturn(firestationDtos);
		var actual = this.controller.getAll();
		assertNotNull(actual);
		assertNotNull(actual.getBody());
		assertEquals(1, ((Collection<FirestationDto>)actual.getBody()).size());
	}

	@Test
	void update() {
		var firestationDto = TestHelper.getFirestationDto();
		when(this.service.update(any(CrudDto.class))).thenReturn(firestationDto);
		var actual = this.controller.update(firestationDto);
		assertNotNull(actual);
		assertEquals(firestationDto,(FirestationDto)actual.getBody());
	}
}