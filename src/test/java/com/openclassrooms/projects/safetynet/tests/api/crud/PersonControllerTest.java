package com.openclassrooms.projects.safetynet.tests.api.crud;

import com.openclassrooms.projects.safetynet.api.crud.PersonController;
import com.openclassrooms.projects.safetynet.domain.dto.crud.PersonDto;
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
class PersonControllerTest {
	@Mock
	CrudService service;

	@InjectMocks
	private PersonController controller;

	@Test
	void add() {
		var personDto = TestHelper.getPersonDto();
		when(this.service.add(any(CrudDto.class))).thenReturn(personDto);
		var actual = this.controller.add(personDto);
		assertNotNull(actual);
		assertEquals(personDto,(PersonDto)actual.getBody());
	}

	@Test
	void delete() {
		var personDto = TestHelper.getPersonDto();
		when(this.service.delete(any(CrudDto.class))).thenReturn(true);
		var actual = this.controller.delete(personDto);
		assertNotNull(actual);
		assertTrue((Boolean)actual.getBody());
	}

	@Test
	void getAll() {
		var personDtos = List.of(TestHelper.getPersonDto());
		when(this.service.getAll()).thenReturn(personDtos);
		var actual = this.controller.getAll();
		assertNotNull(actual);
		assertNotNull(actual.getBody());
		assertEquals(1, ((Collection<PersonDto>) actual.getBody()).size());
	}

	@Test
	void update() {
		var personDto = TestHelper.getPersonDto();
		when(this.service.update(any(CrudDto.class))).thenReturn(personDto);
		var actual = this.controller.update(personDto);
		assertNotNull(actual);
		assertEquals(personDto,(PersonDto)actual.getBody());
	}
}