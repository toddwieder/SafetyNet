package com.openclassrooms.projects.safetynet.domain.interfaces;

import com.openclassrooms.projects.safetynet.domain.model.Firestation;
import com.openclassrooms.projects.safetynet.domain.model.MedicalRecord;
import com.openclassrooms.projects.safetynet.domain.model.Person;
import java.util.stream.Stream;

public interface DataContext {
	Stream<Person> persons();

	Stream<MedicalRecord> medicalRecords();

	Stream<Firestation> firestations();
}
