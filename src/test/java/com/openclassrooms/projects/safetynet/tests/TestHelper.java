package com.openclassrooms.projects.safetynet.tests;

import com.openclassrooms.projects.safetynet.domain.dto.PersonInfoDto;
import com.openclassrooms.projects.safetynet.domain.dto.crud.FirestationDto;
import com.openclassrooms.projects.safetynet.domain.dto.crud.MedicalRecordDto;
import com.openclassrooms.projects.safetynet.domain.dto.crud.PersonDto;
import com.openclassrooms.projects.safetynet.domain.model.Firestation;
import com.openclassrooms.projects.safetynet.domain.model.MedicalRecord;
import com.openclassrooms.projects.safetynet.domain.model.Medication;
import com.openclassrooms.projects.safetynet.domain.model.Person;
import com.openclassrooms.projects.safetynet.domain.model.SafetyNetData;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum TestHelper {
	;

	public static ArrayList<Person> getArrayWithOnePerson() {
		var people = new ArrayList<Person>();
		var person = new Person();
		person.setFirstName("John");
		person.setLastName("Doe");
		person.setAddress("123 Main St");
		person.setCity("New York");
		person.setZip("12345");
		person.setEmail("jdoe@none.com");
		person.setPhone("555-555-5555");
		person.setAge(5);
		var medicalRecord = new MedicalRecord();
		medicalRecord.setFirstName("John");
		medicalRecord.setLastName("Doe");
		medicalRecord.setBirthdate(new Date("1/1/2001"));
		medicalRecord.setAllergies(List.of("none"));
		var medication = new Medication();
		medication.setDosage("100mg");
		medication.setDrug("Asperin");
		medicalRecord.setMedications(List.of(medication));
		person.setMedicalRecord(medicalRecord);
		person.setFirestationNumber(1);
		people.add(person);
		return people;
	}

	public static List<PersonInfoDto> getArrayWithOnePersonInfoDto() {
		return List.of(new PersonInfoDto(
				"John",
				"Doe",
				"123 Main St",
				"555-555-5555"
		));
	}

	public static List<Firestation> getArrayWithTwoFirestations() {
		List<Firestation> firestations = new ArrayList<Firestation>();
		var firestation1 = new Firestation();
		firestation1.setAddress("123 Main St");
		firestation1.setStation(1);
		firestations.add(firestation1);

		var firestation2 = new Firestation();
		firestation2.setAddress("234 Pine Ave");
		firestation2.setStation(2);
		firestations.add(firestation2);
		return firestations;

	}

	public static List<Person> getArrayWithTwoPeople(){
		var people = getArrayWithOnePerson();
		var person = new Person();
		person.setFirstName("Jane");
		person.setLastName("Smith");
		person.setAddress("234 Somewhere St");
		person.setCity("Chicago");
		person.setZip("234568");
		person.setEmail("jsmith@aol.com");
		person.setPhone("777-777-7777");
		person.setAge(25);
		var medicalRecord = new MedicalRecord();
		medicalRecord.setFirstName("Jane");
		medicalRecord.setLastName("Smith");
		medicalRecord.setBirthdate(new Date("1/1/1971"));
		medicalRecord.setAllergies(List.of("none"));
		var medication = new Medication();
		medication.setDosage("100mg");
		medication.setDrug("Asperin");
		medicalRecord.setMedications(List.of(medication));
		person.setMedicalRecord(medicalRecord);
		person.setFirestationNumber(2);
		people.add(person);
		return people;
	}
	public static List<Person> getArrayWithOnePersonWithHousehold(){
		var people = getArrayWithOnePerson();
		people.getFirst().setHouseholdMembers(getArrayWithTwoPeople());
		return people;
	}

	public static FirestationDto getFirestationDto() {
		return new FirestationDto();
	}

	public static Map<Integer, Map<String, List<Person>>> getFirestationHouseholds() {
		var expected = new HashMap<Integer, Map<String, List<Person>>>();
		Map<String, List<Person>> households = new HashMap<String, List<Person>>();
		var person = TestHelper.getArrayWithOnePersonWithHousehold();
		households.put("123 Main St", person);
		expected.put(1, households);
		return expected;
	}

	public static Firestation getFirestation() {
		var firestation = new Firestation();
		firestation.setStation(1);
		firestation.setAddress("123 Main St");
		return firestation;
	}

	public static MedicalRecord getMedicalRecord() {
		var medicalRecord = new MedicalRecord();
		medicalRecord.setFirstName("Jane");
		medicalRecord.setLastName("Smith");
		medicalRecord.setBirthdate(new Date("1/1/1971"));
		medicalRecord.setAllergies(List.of("peanuts"));
		medicalRecord.setMedications(List.of(new Medication()));
		return medicalRecord;
	}

	public static MedicalRecordDto getMedicalRecordDto() {
		return new MedicalRecordDto();
	}

	public static Person getPerson() {
		var person = new Person();
		person.setFirstName("Mary");
		person.setLastName("Jones");
		person.setAddress("9 B Ave.");
		person.setCity("New York");
		person.setZip("12345");
		person.setPhone("555-555-5555");
		person.setEmail("A@b.com");
		return person;
	}

	public static PersonDto getPersonDto() {
		return new PersonDto();
	}

	public static SafetyNetData getSafetyNetData() {
		var safetyNetData= new SafetyNetData();
		safetyNetData.setPersons(getArrayWithTwoPeople());
		safetyNetData.setFirestations(new ArrayList<Firestation>(List.of(getFirestation())));
		safetyNetData.setMedicalRecords(new ArrayList<MedicalRecord>(List.of(getMedicalRecord())));
		return safetyNetData;
	}
}
