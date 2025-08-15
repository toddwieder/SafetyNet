package com.openclassrooms.projects.safetynet.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Medication {
// region fields
	private String dosage;
	private String drug;
//endregion

// region constructors
	public Medication(String drugAndDosage) {
		if (drugAndDosage != null) {
			var values = drugAndDosage.split(":");
			this.drug = values[0];
			this.dosage = values[1];
		}
	}

	public Medication() {
	}
// endregion

}
