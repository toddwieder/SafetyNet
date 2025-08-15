package com.openclassrooms.projects.safetynet.tests.repository;

import com.openclassrooms.projects.safetynet.domain.model.MedicalRecord;
import com.openclassrooms.projects.safetynet.data.FileDataAdapter;
import com.openclassrooms.projects.safetynet.repository.crud.MedicalRecordRepository;
import com.openclassrooms.projects.safetynet.tests.TestHelper;
import java.util.Date;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MedicalRecordRepositoryTest {
	@Mock
	private FileDataAdapter context;

	@InjectMocks
	private MedicalRecordRepository repository;

	@Test
	void saveTest() {
		when(this.context.saveChanges()).thenReturn(Boolean.TRUE);
		var actual = this.repository.save();
		assertTrue(actual);
	}

	@Test
	void addTest() {
		when(this.context.addMedicalRecord(any(MedicalRecord.class))).thenAnswer(i -> i.getArgument(0));
		var actual = this.repository.add(TestHelper.getMedicalRecord());
		assertNotNull(actual);
		assert(actual.getLastName().equals("Smith"));
	}

	@Test
	void deleteTest() {
		when(this.context.deleteMedicalRecord(any(MedicalRecord.class))).thenReturn(Boolean.TRUE);
		var actual = this.repository.delete(TestHelper.getMedicalRecord());
		assertTrue(actual);
	}

	@Test
	void getTest() {
		when(this.context.getMedicalRecord(any(MedicalRecord.class))).thenReturn(TestHelper.getMedicalRecord());
		var actual = this.repository.get(TestHelper.getMedicalRecord());
		assertNotNull(actual);
		assertEquals(TestHelper.getMedicalRecord().getFirstName(), actual.getFirstName());
	}

	@Test
	void getAllTest() {
		when(this.context.medicalRecords()).thenReturn(Stream.of(TestHelper.getMedicalRecord()));
		var actual = this.repository.getAll();
		assertNotNull(actual);
		assertEquals(1, actual.size());
	}

	@Test
	void updateTest() {
		when(this.context.getMedicalRecord(any(MedicalRecord.class))).thenReturn(TestHelper.getMedicalRecord());
		when(this.context.updateMedicalRecord(any(MedicalRecord.class))).thenAnswer(i -> i.getArgument(0));
		var medicalRecord = TestHelper.getMedicalRecord();
		medicalRecord.setBirthdate(new Date("9/9/2009"));
		var actual = this.repository.update(medicalRecord);
		assertNotNull(actual);
		assertEquals(new Date("9/9/2009"), actual.getBirthdate());
	}
}