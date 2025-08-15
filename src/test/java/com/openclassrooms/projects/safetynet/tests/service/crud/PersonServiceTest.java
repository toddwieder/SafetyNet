package com.openclassrooms.projects.safetynet.tests.service.crud;

import com.openclassrooms.projects.safetynet.domain.dto.crud.PersonDto;
import com.openclassrooms.projects.safetynet.domain.mapper.PersonMapper;
import com.openclassrooms.projects.safetynet.domain.model.Person;
import com.openclassrooms.projects.safetynet.repository.crud.CrudRepository;
import com.openclassrooms.projects.safetynet.service.crud.PersonService;
import com.openclassrooms.projects.safetynet.tests.TestHelper;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.Spy;
import org.mockito.junit.jupiter.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {
	@Mock
	CrudRepository repository;
	@Spy
	PersonMapper personMapper = new PersonMapper();

	@InjectMocks
	private PersonService service;

	@Test
	void getAll() {
		when(this.repository.getAll()).thenReturn(List.of(TestHelper.getPerson()));
		var result = this.service.getAll();
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	@Test
	void get() {
		var testPerson = TestHelper.getPerson();
		when(this.repository.get(any(Person.class))).thenReturn(testPerson);
		var result = this.service.get(new PersonDto());
		assertNotNull(result);
		assertEquals(testPerson.getAddress(), result.getAddress());
	}

	@Test
	void add() {
		var testPerson = TestHelper.getPerson();
		when(this.repository.add(any(Person.class))).thenReturn(testPerson);
		var result = this.service.add(new PersonDto());
		assertNotNull(result);
		assertEquals(testPerson.getAddress(), result.getAddress());
	}

	@Test
	void update() {
		var testPerson = TestHelper.getPerson();
		when(this.repository.update(any(Person.class))).thenReturn(testPerson);
		testPerson.setCity("City");
		var result = this.service.update(new PersonDto());
		assertNotNull(result);
		assertEquals("City", result.getCity());
	}

	@Test
	void delete() {
		when(this.repository.delete(any(Person.class))).thenReturn(true);
		var result = this.service.delete(new PersonDto());
		assertNotNull(result);
		assertTrue(result);
	}
}