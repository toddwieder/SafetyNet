package com.openclassrooms.projects.safetynet.data;

import com.openclassrooms.projects.safetynet.domain.interfaces.DataAdapter;
import com.openclassrooms.projects.safetynet.domain.model.Firestation;
import com.openclassrooms.projects.safetynet.domain.model.MedicalRecord;
import com.openclassrooms.projects.safetynet.domain.model.Person;
import com.openclassrooms.projects.safetynet.domain.model.SafetyNetData;
import com.openclassrooms.projects.safetynet.domain.utility.ModelHelper;
import com.openclassrooms.projects.safetynet.data.filereader.SafetyNetDataFileReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileDataAdapter implements DataAdapter {
	// region fields
	@Getter
	private SafetyNetData data;
	private SafetyNetDataFileReader fileReader;
	//endregion

	// region constructors
	@Autowired
	public FileDataAdapter(SafetyNetDataFileReader fileReader) {
		this.fileReader = fileReader;
		initializeData();
	}

	public FileDataAdapter() {
	}

	// region public methods

	@Override
	public Stream<Firestation> firestations() {
		return this.getData().getFirestations().stream();
	}
	@Override
	public Stream<MedicalRecord> medicalRecords() {
		return this.getData().getMedicalRecords().stream();
	}

	@Override
	public Stream<Person> persons() {
		return this.getData().getPersons().stream();
	}

	@Override
	public Firestation addFirestation(Firestation firestation) {
		this.getData().getFirestations().add(firestation);
		return firestation;
	}

	@Override
	public MedicalRecord addMedicalRecord(MedicalRecord medicalRecord) {
		this.getData().getMedicalRecords().add(medicalRecord);
		return medicalRecord;
	}

	@Override
	public Person addPerson(Person person) {
		this.getData().getPersons().add(person);
		return person;
	}

	@Override
	public boolean deleteFirestation(Firestation firestation) {
		try {
			var thisFirestation = this.getFirestation(firestation.getStation());
			this.getData().getFirestations().remove(thisFirestation);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteMedicalRecord(MedicalRecord medicalRecord) {
		try {
			var thisRecord = this.getMedicalRecord(medicalRecord.getFirstName(),
					medicalRecord.getLastName());
			this.getData().getMedicalRecords().remove(thisRecord);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean deletePerson(Person person) {
		try {
			var thisPerson = this.getPerson(person.getFirstName(), person.getLastName());
			this.getData().getPersons().remove(thisPerson);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Firestation getFirestation(Firestation firestation) {
		return this.getFirestation(firestation.getStation());
	}

	@Override
	public MedicalRecord getMedicalRecord(MedicalRecord medicalRecord) {
		return this.getMedicalRecord(medicalRecord.getFirstName(), medicalRecord.getLastName());
	}

	private MedicalRecord getMedicalRecord(String firstName, String lastName) {
		return this.getData().getMedicalRecords().stream()
		           .filter(m -> m.getFirstName().equals(firstName) && m.getLastName()
		                                                               .equals(lastName))
		           .findFirst().orElse(null);
	}

	@Override
	public Person getPerson(Person person) {
		return this.getPerson(person.getFirstName(), person.getLastName());
	}

	@Override
	public boolean saveChanges() {
		var result = this.fileReader.saveFile(this.getData());
		this.initializeData();
		return result;
	}

	@Override
	public Firestation updateFirestation(Firestation firestation) {
		var thisFirestation = this.getFirestation(firestation.getStation());

		if (thisFirestation == null) {
			return addFirestation(firestation);
		}

		var index = this.getData().getFirestations().indexOf(thisFirestation);
		this.getData().getFirestations().set(index, firestation);
		return firestation;
	}

	@Override
	public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord) {
		var thisRecord = this.getMedicalRecord(medicalRecord.getFirstName(),
				medicalRecord.getLastName());

		if (thisRecord == null) {
			return addMedicalRecord(medicalRecord);
		}

		var index = this.getData().getMedicalRecords().indexOf(thisRecord);
		this.getData().getMedicalRecords().set(index, medicalRecord);
		return medicalRecord;
	}

	@Override
	public Person updatePerson(Person person) {
		Person thisPerson = this.getPerson(person.getFirstName(), person.getLastName());

		if (thisPerson == null) {
			return addPerson(person);
		}

		var index = this.getData().getPersons().indexOf(thisPerson);
		this.getData().getPersons().set(index, person);

		return person;
	}

	// region private methods

	private void buildForeignKeys() {
		this.getData().getPersons().forEach(p -> {
			var medicalRecord = this.getData().getMedicalRecords().stream()
			                        .filter(mr -> p.getFirstName()
			                                       .equals(mr.getFirstName()) && p.getLastName()
			                                                                      .equals(mr.getLastName()))
			                        .findFirst().orElse(null);
			if (medicalRecord != null) {
				p.setMedicalRecord(medicalRecord);
				p.setAge(ModelHelper.getAge(medicalRecord.getBirthdate()));
			}

			this.getData().getFirestations().stream()
			    .filter(fs -> fs.getAddress().equals(p.getAddress())).findFirst()
			    .ifPresent(firestation -> p.setFirestationNumber(firestation.getStation()));

			p.setHouseholdMembers(this.getData().getPersons().stream().filter(p2 -> p2.getAddress()
			                                                                          .equals(p.getAddress()) && !(p2.getFirstName()
			                                                                                                         .equals(p.getFirstName()) && p2.getLastName()
			                                                                                                                                        .equals(p.getLastName())))
			                          .collect(Collectors.toList()));

		});
	}
	private Firestation getFirestation(Integer station) {
		return this.getData().getFirestations().stream().filter(f -> f.getStation().equals(station))
		           .findFirst().orElse(null);
	}

	private Person getPerson(String firstName, String lastName) {
		return this.getData().getPersons().stream()
		           .filter(p -> p.getFirstName().equals(firstName) && p.getLastName()
		                                                               .equals(lastName))
		           .findFirst().orElse(null);
	}

	private void initializeData() {
		this.data = this.fileReader.readFile();
		buildForeignKeys();
	}
}
