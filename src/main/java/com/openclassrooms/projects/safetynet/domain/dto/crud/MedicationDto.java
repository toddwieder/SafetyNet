package com.openclassrooms.projects.safetynet.domain.dto.crud;

import com.openclassrooms.projects.safetynet.domain.interfaces.CrudDto;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Medication dto.
 */
@Getter
@Setter
public class MedicationDto implements CrudDto {
	private String drug;

	private String dosage;

	/**
	 * Instantiates a new Medication dto.
	 *
	 * @param drug   the drug
	 * @param dosage the dosage
	 */
	public MedicationDto(String drug, String dosage) {
		this.drug = drug;
		this.dosage = dosage;
	}
}
