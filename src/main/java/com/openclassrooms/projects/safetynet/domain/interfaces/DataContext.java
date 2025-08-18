package com.openclassrooms.projects.safetynet.domain.interfaces;

import com.openclassrooms.projects.safetynet.domain.model.Firestation;
import com.openclassrooms.projects.safetynet.domain.model.MedicalRecord;
import com.openclassrooms.projects.safetynet.domain.model.Person;
import java.util.stream.Stream;

/**
 * The interface Data context.
 */
public interface DataContext {
	/**
	 * Persons stream.
	 *
	 * @return the stream
	 */
	Stream<Person> persons();

	/**
	 * Medical records stream.
	 *
	 * @return the stream
	 */
	Stream<MedicalRecord> medicalRecords();

	/**
	 * Firestations stream.
	 *
	 * @return the stream
	 */
	Stream<Firestation> firestations();
}
