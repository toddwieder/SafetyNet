package com.openclassrooms.projects.safetynet.tests.service.crud;

import com.openclassrooms.projects.safetynet.domain.dto.crud.MedicalRecordDto;
import com.openclassrooms.projects.safetynet.domain.mapper.MedicalRecordMapper;
import com.openclassrooms.projects.safetynet.domain.model.MedicalRecord;
import com.openclassrooms.projects.safetynet.repository.crud.CrudRepository;
import com.openclassrooms.projects.safetynet.service.crud.MedicalRecordService;
import com.openclassrooms.projects.safetynet.tests.TestHelper;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MedicalRecordServiceTest {
	@Mock
	CrudRepository repository;
	@Spy
	MedicalRecordMapper mapper = new MedicalRecordMapper();

	@InjectMocks
	private MedicalRecordService service;

	@Test
	void getAll() {
		when(this.repository.getAll()).thenReturn(List.of(TestHelper.getMedicalRecord()));
		var result = this.service.getAll();
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	@Test
	void get() {
		var testMedicalRecord = TestHelper.getMedicalRecord();
		when(this.repository.get(any(MedicalRecord.class))).thenReturn(testMedicalRecord);
		var result = this.service.get(new MedicalRecordDto());
		assertNotNull(result);
		assertEquals(testMedicalRecord.getFirstName(), result.getFirstName());
	}

	@Test
	void add() {
		var testMedicalRecord = TestHelper.getMedicalRecord();
		when(this.repository.add(any(MedicalRecord.class))).thenReturn(testMedicalRecord);
		var result = this.service.add(new MedicalRecordDto());
		assertNotNull(result);
		assertEquals(testMedicalRecord.getFirstName(), result.getFirstName());
	}

	@Test
	void update() {
		var testMedicalRecord = TestHelper.getMedicalRecord();
		when(this.repository.update(any(MedicalRecord.class))).thenReturn(testMedicalRecord);
		testMedicalRecord.setFirstName("First Name");
		var result = this.service.update(new MedicalRecordDto());
		assertNotNull(result);
		assertEquals("First Name", result.getFirstName());
	}

	@Test
	void delete() {
		when(this.repository.delete(any(MedicalRecord.class))).thenReturn(true);
		var result = this.service.delete(new MedicalRecordDto());
		assertNotNull(result);
		assertTrue(result);
	}
}