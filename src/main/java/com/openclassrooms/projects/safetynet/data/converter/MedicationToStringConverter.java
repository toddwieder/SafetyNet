package com.openclassrooms.projects.safetynet.data.converter;

import com.fasterxml.jackson.databind.util.StdConverter;
import com.openclassrooms.projects.safetynet.domain.model.Medication;
import java.util.List;

/**
 * The type Medication to string converter.
 */
public class MedicationToStringConverter extends StdConverter<List<Medication>, List<String>> {

	@Override
	public List<String> convert(final List<Medication> medications) {
		return medications.stream().map(m -> String.join(":", m.getDrug(), m.getDosage())).toList();
	}
}

