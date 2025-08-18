package com.openclassrooms.projects.safetynet.data;

import com.openclassrooms.projects.safetynet.data.filereader.SafetyNetDataFileReader;
import com.openclassrooms.projects.safetynet.domain.interfaces.DataAdapter;
import com.openclassrooms.projects.safetynet.domain.model.Firestation;
import com.openclassrooms.projects.safetynet.domain.model.MedicalRecord;
import com.openclassrooms.projects.safetynet.domain.model.Person;
import com.openclassrooms.projects.safetynet.domain.model.SafetyNetData;
import com.openclassrooms.projects.safetynet.domain.utility.ModelHelper;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type File data adapter.
 */
@Service
public class FileDataAdapter implements DataAdapter {

	@Getter
	private SafetyNetData data;

	private SafetyNetDataFileReader fileReader;

	/**
	 * Instantiates a new File data adapter.
	 *
	 * @param fileReader the file reader
	 */
	@Autowired
	public FileDataAdapter(final SafetyNetDataFileReader fileReader) {
		this.fileReader = fileReader;
		this.initializeData();
	}

	/**
	 * Instantiates a new File data adapter.
	 */
	public FileDataAdapter() {
	}

	@Override
	public Firestation addFirestation(final Firestation firestation) {
		data.getFirestations().add(firestation);
		return firestation;
	}

	@Override
	public MedicalRecord addMedicalRecord(final MedicalRecord medicalRecord) {
		data.getMedicalRecords().add(medicalRecord);
		return medicalRecord;
	}

	@Override
	public Person addPerson(final Person person) {
		data.getPersons().add(person);
		return person;
	}

	@Override
	public boolean deleteFirestation(final Firestation firestation) {
		try {
			final var thisFirestation = getFirestation(firestation.getStation());
			data.getFirestations().remove(thisFirestation);
			return true;
		} catch (final Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteMedicalRecord(final MedicalRecord medicalRecord) {
		try {
			final var thisRecord = getMedicalRecord(medicalRecord.getFirstName(),
					medicalRecord.getLastName());
			data.getMedicalRecords().remove(thisRecord);
			return true;
		} catch (final Exception e) {
			return false;
		}
	}

	@Override
	public boolean deletePerson(final Person person) {
		try {
			final var thisPerson = getPerson(person.getFirstName(), person.getLastName());
			data.getPersons().remove(thisPerson);
			return true;
		} catch (final Exception e) {
			return false;
		}
	}

	@Override
	public Stream<Firestation> firestations() {
		return data.getFirestations().stream();
	}

	@Override
	public Firestation getFirestation(final Firestation firestation) {
		return getFirestation(firestation.getStation());
	}

	@Override
	public MedicalRecord getMedicalRecord(final MedicalRecord medicalRecord) {
		return getMedicalRecord(medicalRecord.getFirstName(), medicalRecord.getLastName());
	}

	@Override
	public Person getPerson(final Person person) {
		return getPerson(person.getFirstName(), person.getLastName());
	}

	@Override
	public Stream<MedicalRecord> medicalRecords() {
		return data.getMedicalRecords().stream();
	}

	@Override
	public Stream<Person> persons() {
		return data.getPersons().stream();
	}

	@Override
	public boolean saveChanges() {
		final var result = fileReader.saveFile(data);
		initializeData();
		return result;
	}

	@Override
	public Firestation updateFirestation(final Firestation firestation) {
		final var thisFirestation = getFirestation(firestation.getStation());

		if (null == thisFirestation) {
			return this.addFirestation(firestation);
		}

		final var index = data.getFirestations().indexOf(thisFirestation);
		data.getFirestations().set(index, firestation);
		return firestation;
	}

	@Override
	public MedicalRecord updateMedicalRecord(final MedicalRecord medicalRecord) {
		final var thisRecord = getMedicalRecord(medicalRecord.getFirstName(),
				medicalRecord.getLastName());

		if (null == thisRecord) {
			return this.addMedicalRecord(medicalRecord);
		}

		final var index = data.getMedicalRecords().indexOf(thisRecord);
		data.getMedicalRecords().set(index, medicalRecord);
		return medicalRecord;
	}

	@Override
	public Person updatePerson(final Person person) {
		final Person thisPerson = getPerson(person.getFirstName(), person.getLastName());

		if (null == thisPerson) {
			return this.addPerson(person);
		}

		final var index = data.getPersons().indexOf(thisPerson);
		data.getPersons().set(index, person);

		return person;
	}

	private void buildForeignKeys() {
		data.getPersons().forEach(p -> {
			final var medicalRecord = data.getMedicalRecords().stream()
			                              .filter(mr -> p.getFirstName()
			                                       .equals(mr.getFirstName()) && p.getLastName()
			                                                                      .equals(mr.getLastName()))
			                              .findFirst().orElse(null);
			if (null != medicalRecord) {
				p.setMedicalRecord(medicalRecord);
				p.setAge(ModelHelper.getAge(medicalRecord.getBirthdate()));
			}

			data.getFirestations().stream()
			         .filter(fs -> fs.getAddress().equals(p.getAddress())).findFirst()
			         .ifPresent(firestation -> p.setFirestationNumber(firestation.getStation()));

			p.setHouseholdMembers(data.getPersons().stream().filter(p2 -> p2.getAddress()
			                                                                .equals(p.getAddress()) && !(p2.getFirstName()
			                                                                                                         .equals(p.getFirstName()) && p2.getLastName()
			                                                                                                                                        .equals(p.getLastName())))
			                          .toList());

		});
	}

	private Firestation getFirestation(final Integer station) {
		return data.getFirestations().stream().filter(f -> f.getStation().equals(station))
		                .findFirst().orElse(null);
	}

	private MedicalRecord getMedicalRecord(final String firstName, final String lastName) {
		return data.getMedicalRecords().stream()
		                .filter(m -> m.getFirstName().equals(firstName) && m.getLastName()
		                                                               .equals(lastName))
		                .findFirst().orElse(null);
	}

	private Person getPerson(final String firstName, final String lastName) {
		return data.getPersons().stream()
		                .filter(p -> p.getFirstName().equals(firstName) && p.getLastName()
		                                                               .equals(lastName))
		                .findFirst().orElse(null);
	}

	private void initializeData() {
		data = fileReader.readFile();
		this.buildForeignKeys();
	}
}
