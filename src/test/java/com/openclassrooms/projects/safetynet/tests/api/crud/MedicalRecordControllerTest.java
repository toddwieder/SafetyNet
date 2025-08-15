package com.openclassrooms.projects.safetynet.tests.api.crud;

import com.openclassrooms.projects.safetynet.api.crud.MedicalRecordController;
import com.openclassrooms.projects.safetynet.domain.dto.crud.MedicalRecordDto;
import com.openclassrooms.projects.safetynet.domain.interfaces.CrudDto;
import com.openclassrooms.projects.safetynet.service.crud.CrudService;
import com.openclassrooms.projects.safetynet.tests.TestHelper;
import java.util.Collection;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MedicalRecordControllerTest {
	@Mock
	CrudService service;

	@InjectMocks
	private MedicalRecordController controller;

	@Test
	void add() {
		var medicalRecordDto = TestHelper.getMedicalRecordDto();
		when(this.service.add(any(CrudDto.class))).thenReturn(medicalRecordDto);
		var actual = this.controller.add(medicalRecordDto);
		assertNotNull(actual);
		assertEquals(medicalRecordDto,(MedicalRecordDto)actual.getBody());
	}

	@Test
	void delete() {
		var medicalRecordDto = TestHelper.getMedicalRecordDto();
		when(this.service.delete(any(CrudDto.class))).thenReturn(true);
		var actual = this.controller.delete(medicalRecordDto);
		assertNotNull(actual);
		assertTrue((Boolean)actual.getBody());
	}

	@Test
	void getAll() {
		var medicalRecordDtos = List.of(TestHelper.getMedicalRecordDto());
		when(this.service.getAll()).thenReturn(medicalRecordDtos);
		var actual = this.controller.getAll();
		assertNotNull(actual);
		assertNotNull(actual.getBody());
		assertEquals(1, ((Collection<MedicalRecordDto>) actual.getBody()).size());
	}

	@Test
	void update() {
		var medicalRecordDto = TestHelper.getMedicalRecordDto();
		when(this.service.update(any(CrudDto.class))).thenReturn(medicalRecordDto);
		var actual = this.controller.update(medicalRecordDto);
		assertNotNull(actual);
		assertEquals(medicalRecordDto,(MedicalRecordDto)actual.getBody());
	}
}