package com.openclassrooms.projects.safetynet.domain.mapper;

import com.openclassrooms.projects.safetynet.domain.dto.crud.MedicalRecordDto;
import com.openclassrooms.projects.safetynet.domain.dto.crud.MedicationDto;
import com.openclassrooms.projects.safetynet.domain.model.MedicalRecord;
import com.openclassrooms.projects.safetynet.domain.model.Medication;
import com.openclassrooms.projects.safetynet.domain.interfaces.CrudMapper;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class MedicalRecordMapper implements CrudMapper<MedicalRecord, MedicalRecordDto> {
	public MedicalRecord toModel(MedicalRecordDto dto) {
		var medicalRecord= new MedicalRecord();
		medicalRecord.setFirstName(dto.getFirstName());
		medicalRecord.setLastName(dto.getLastName());
		medicalRecord.setBirthdate(dto.getBirthdate());
		medicalRecord.setAllergies(dto.getAllergies());
		medicalRecord.setMedications(dto.getMedications().stream().map(this::toMedication).toList());
		return medicalRecord;
	}

	private Medication toMedication(MedicationDto dto){
		var medication = new Medication();
		medication.setDosage(dto.getDosage());
		medication.setDrug(medication.getDrug());
		return medication;
	}

	public MedicalRecordDto toDto(MedicalRecord model) {
		var dto= new MedicalRecordDto();
		dto.setFirstName(model.getFirstName());
		dto.setLastName(model.getLastName());
		dto.setBirthdate(model.getBirthdate());
		dto.setAllergies(model.getAllergies());
		dto.setMedications(model.getMedications().stream().map(this::toMedicationDto).toList());
		return dto;
	}

	private MedicationDto toMedicationDto(Medication model){
		return new MedicationDto(model.getDrug(), model.getDosage());
	}
}
