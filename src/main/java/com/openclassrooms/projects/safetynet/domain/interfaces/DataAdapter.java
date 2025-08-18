package com.openclassrooms.projects.safetynet.domain.interfaces;

import com.openclassrooms.projects.safetynet.domain.model.Firestation;
import com.openclassrooms.projects.safetynet.domain.model.MedicalRecord;
import com.openclassrooms.projects.safetynet.domain.model.Person;

/**
 * The interface Data adapter.
 */
public interface DataAdapter extends DataContext {

	/**
	 * Add firestation firestation.
	 *
	 * @param firestation the firestation
	 * @return the firestation
	 */
	Firestation addFirestation(Firestation firestation);

	/**
	 * Add medical record medical record.
	 *
	 * @param medicalRecord the medical record
	 * @return the medical record
	 */
	MedicalRecord addMedicalRecord(MedicalRecord medicalRecord);

	/**
	 * Add person person.
	 *
	 * @param person the person
	 * @return the person
	 */
	Person addPerson(Person person);

	/**
	 * Delete firestation boolean.
	 *
	 * @param firestation the firestation
	 * @return the boolean
	 */
	boolean deleteFirestation(Firestation firestation);

	/**
	 * Delete medical record boolean.
	 *
	 * @param medicalRecord the medical record
	 * @return the boolean
	 */
	boolean deleteMedicalRecord(MedicalRecord medicalRecord);

	/**
	 * Delete person boolean.
	 *
	 * @param person the person
	 * @return the boolean
	 */
	boolean deletePerson(Person person);

	/**
	 * Gets firestation.
	 *
	 * @param firestation the firestation
	 * @return the firestation
	 */
	Firestation getFirestation(Firestation firestation);

	/**
	 * Gets medical record.
	 *
	 * @param medicalRecord the medical record
	 * @return the medical record
	 */
	MedicalRecord getMedicalRecord(MedicalRecord medicalRecord);

	/**
	 * Gets person.
	 *
	 * @param person the person
	 * @return the person
	 */
	Person getPerson(Person person);

	/**
	 * Save changes boolean.
	 *
	 * @return the boolean
	 */
	boolean saveChanges();

	/**
	 * Update firestation firestation.
	 *
	 * @param firestation the firestation
	 * @return the firestation
	 */
	Firestation updateFirestation(Firestation firestation);

	/**
	 * Update medical record medical record.
	 *
	 * @param medicalRecord the medical record
	 * @return the medical record
	 */
	MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord);

	/**
	 * Update person person.
	 *
	 * @param person the person
	 * @return the person
	 */
	Person updatePerson(Person person);
}
