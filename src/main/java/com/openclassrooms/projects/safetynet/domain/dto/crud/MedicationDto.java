package com.openclassrooms.projects.safetynet.domain.dto.crud;

import com.openclassrooms.projects.safetynet.domain.interfaces.CrudDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicationDto implements CrudDto {
	private String drug;

	private String dosage;

	public MedicationDto(String drug, String dosage) {
		this.drug = drug;
		this.dosage = dosage;
	}
}
