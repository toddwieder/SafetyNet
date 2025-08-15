package com.openclassrooms.projects.safetynet.data.mixin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.openclassrooms.projects.safetynet.domain.model.Medication;
import com.openclassrooms.projects.safetynet.data.converter.MedicationToStringConverter;
import com.openclassrooms.projects.safetynet.data.converter.StringToMedicationConverter;
import java.util.Date;
import java.util.List;

public abstract class MedicalRecordMixin {
	private String firstName;
	private String lastName;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
	private Date birthdate;

	@JsonDeserialize(converter = StringToMedicationConverter.class)
	@JsonSerialize(converter = MedicationToStringConverter.class)
	private List<Medication> medications;

	private List<String> allergies;
}
