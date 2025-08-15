package com.openclassrooms.projects.safetynet.domain.interfaces;

import com.openclassrooms.projects.safetynet.domain.model.Firestation;
import com.openclassrooms.projects.safetynet.domain.model.MedicalRecord;
import com.openclassrooms.projects.safetynet.domain.model.Person;

public interface DataAdapter extends DataContext {

	Person getPerson(Person person);

	Person addPerson(Person person);

	Person updatePerson(Person person);

	boolean deletePerson(Person person);

	Firestation getFirestation(Firestation firestation);

	Firestation addFirestation(Firestation firestation);

	Firestation updateFirestation(Firestation firestation);

	boolean deleteFirestation(Firestation firestation);

	MedicalRecord getMedicalRecord(MedicalRecord medicalRecord);

	MedicalRecord addMedicalRecord(MedicalRecord medicalRecord);

	MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord);

	boolean deleteMedicalRecord(MedicalRecord medicalRecord);

	boolean saveChanges();
}
