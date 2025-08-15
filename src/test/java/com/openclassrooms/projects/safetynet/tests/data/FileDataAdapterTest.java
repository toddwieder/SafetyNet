package com.openclassrooms.projects.safetynet.tests.data;

import com.openclassrooms.projects.safetynet.data.FileDataAdapter;
import com.openclassrooms.projects.safetynet.data.filereader.SafetyNetDataFileReader;
import com.openclassrooms.projects.safetynet.domain.model.Firestation;
import com.openclassrooms.projects.safetynet.tests.TestHelper;
import java.util.Date;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FileDataAdapterTest {
	@Mock
	SafetyNetDataFileReader reader;


	FileDataAdapter adapter;

	@BeforeEach
	void init(){
		when(this.reader.readFile()).thenReturn(TestHelper.getSafetyNetData());
		this.adapter = new FileDataAdapter(this.reader);
	}

	@Test
	void firestationTest(){
		var actual = this.adapter.firestations().toList();
		assertEquals(1, actual.size());
	}

	@Test
	void medicalRecordsTest() {
		var actual = this.adapter.medicalRecords().toList();
		assertEquals(1, actual.size());
	}

	@Test
	void personsTest() {
		var actual = this.adapter.persons().toList();
		assertEquals(2, actual.size());
	}

	@Test
	void addFirestationTest() {
		var initialCount = this.adapter.firestations().count();
		var actual = this.adapter.addFirestation(new Firestation("123 Main St", 1));
		var finalSize = this.adapter.firestations().count();
		assertEquals("123 Main St", actual.getAddress());
		assertEquals(initialCount+1, finalSize);
	}

	@Test
	void addMedicalRecordTest() {
		var initialCount = this.adapter.medicalRecords().count();
		var actual = this.adapter.addMedicalRecord(TestHelper.getMedicalRecord());
		var finalSize = this.adapter.medicalRecords().count();
		assertEquals("Jane", actual.getFirstName());
		assertEquals(initialCount+1, finalSize);
	}

	@Test
	void addPersonTest() {
		var initialCount = this.adapter.persons().count();
		var actual = this.adapter.addPerson(TestHelper.getPerson());
		var finalSize = this.adapter.persons().count();
		assertEquals("Mary", actual.getFirstName());
		assertEquals(initialCount+1, finalSize);
	}

	@Test
	void deleteFirestationTest() {
		var initialCount = this.adapter.firestations().count();
		var firestation = this.adapter.firestations().findFirst().orElse(null);
		var actual = this.adapter.deleteFirestation(firestation);
		var finalCount = this.adapter.firestations().count();
		assertEquals(initialCount-1, finalCount);
		assertTrue(actual);
	}

	@Test
	void deleteMedicalRecordTest() {
		var initialCount = this.adapter.medicalRecords().count();
		var medicalRecord = this.adapter.medicalRecords().findFirst().orElse(null);
		var actual = this.adapter.deleteMedicalRecord(medicalRecord);
		var finalCount = this.adapter.medicalRecords().count();
		assertEquals(initialCount-1, finalCount);
		assertTrue(actual);
	}

	@Test
	void deletePersonTest() {
		var initialCount = this.adapter.persons().count();
		var person = this.adapter.persons().findFirst().orElse(null);
		var actual = this.adapter.deletePerson(person);
		var finalCount = this.adapter.persons().count();
		assertEquals(initialCount-1, finalCount);
		assertTrue(actual);
	}

	@Test
	void getFirestationTest() {
		var firestation = this.adapter.firestations().findFirst().orElse(null);
		Assertions.assertNotNull(firestation);
		var getPerson = this.adapter.getFirestation(firestation);
		assertEquals(firestation, getPerson);
	}

	@Test
	void getMedicalRecordTest() {
		var medicalRecord = this.adapter.medicalRecords().findFirst().orElse(null);
		Assertions.assertNotNull(medicalRecord);
		var getMedicalRecord = this.adapter.getMedicalRecord(medicalRecord);
		assertEquals(medicalRecord, getMedicalRecord);
	}

	@Test
	void getPersonTest() {
		var person = this.adapter.persons().findFirst().orElse(null);
		Assertions.assertNotNull(person);
		var getPerson = this.adapter.getPerson(person);
		assertEquals(person, getPerson);
	}

	@Test
	void updateFirestationTest() {
		String newAddress = "New Address";

		var firestation = this.adapter.firestations().findFirst().orElse(null);
		Assertions.assertNotNull(firestation);
		firestation.setAddress(newAddress);
		var result = this.adapter.updateFirestation(firestation);
		var updated = this.adapter.getFirestation(firestation);
		assertEquals(newAddress, updated.getAddress());
		assertEquals(newAddress, result.getAddress());
		assertEquals(firestation, updated);
	}

	@Test
	void updateMedicalRecordTest() {
		var birthdate = new Date("4/4/1904");

		var medicalRecord = this.adapter.medicalRecords().findFirst().orElse(null);
		Assertions.assertNotNull(medicalRecord);
		medicalRecord.setBirthdate(birthdate);
		var result = this.adapter.updateMedicalRecord(medicalRecord);
		var updated = this.adapter.getMedicalRecord(medicalRecord);
		assertEquals(birthdate, updated.getBirthdate());
		assertEquals(birthdate, result.getBirthdate());
		assertEquals(result, updated);
	}

	@Test
	void updatePersonTest() {
		String newAddress = "New Address";

		var person = this.adapter.persons().findFirst().orElse(null);
		Assertions.assertNotNull(person);
		person.setAddress(newAddress);
		var result = this.adapter.updatePerson(person);
		var updated = this.adapter.getPerson(person);
		assertEquals(result, updated);
		assertEquals(newAddress, result.getAddress());
		assertEquals(newAddress, updated.getAddress());
	}
}