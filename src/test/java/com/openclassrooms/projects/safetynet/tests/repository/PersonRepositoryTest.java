package com.openclassrooms.projects.safetynet.tests.repository;

import com.openclassrooms.projects.safetynet.data.FileDataAdapter;
import com.openclassrooms.projects.safetynet.repository.crud.PersonRepository;
import com.openclassrooms.projects.safetynet.tests.TestHelper;
import static org.junit.jupiter.api.Assertions.*;
import com.openclassrooms.projects.safetynet.domain.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PersonRepositoryTest {
	@Mock
	private FileDataAdapter context;

	@InjectMocks
	private PersonRepository repository;

	@Test
	void saveTest() {
		when(this.context.saveChanges()).thenReturn(Boolean.TRUE);
		var actual = this.repository.save();
		assertTrue(actual);
	}

	@Test
	void deleteTest(){
		when(this.context.deletePerson(any(Person.class))).thenReturn(true);
		var actual = this.repository.delete(TestHelper.getPerson());
		assertTrue(actual);
	}

	@Test
	void getAllTest() {
		when(this.context.persons()).thenReturn(TestHelper.getArrayWithTwoPeople().stream());
		var actual = this.repository.getAll();
		assertEquals(2, actual.size());
	}

	@Test
	void getTest() {
		when(this.context.getPerson(any(Person.class))).thenAnswer(p -> p.getArgument(0));
		var actual = this.repository.get(TestHelper.getPerson());
		assertNotNull(actual);
		assertEquals("Mary",actual.getFirstName());
	}

	@Test
	void addTest() {
		when(this.context.addPerson(any(Person.class))).thenAnswer((p -> p.getArgument(0)));
		var actual = this.repository.add(TestHelper.getPerson());
		assertNotNull(actual);
		assertEquals("Mary", actual.getFirstName());
	}

	@Test
	void updateTest() {
		when(this.context.getPerson(any(Person.class))).thenAnswer((p -> p.getArgument(0)));
		when(this.context.updatePerson(any(Person.class))).thenAnswer((p -> p.getArgument(0)));
		var person = TestHelper.getPerson();
		person.setPhone("999-999-9999");
		var actual = this.repository.update(person);
		assertNotNull(actual);
		assertEquals("999-999-9999" , actual.getPhone());
	}
}