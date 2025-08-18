package com.openclassrooms.projects.safetynet.data.converter;

import com.fasterxml.jackson.databind.util.StdConverter;
import com.openclassrooms.projects.safetynet.domain.model.Medication;
import java.util.List;

/**
 * The type String to medication converter.
 */
public class StringToMedicationConverter extends StdConverter<List<String>, List<Medication>> {

	@Override
	public List<Medication> convert(List<String> medicationStrings) {
		return medicationStrings.stream().map(Medication::new).toList();
	}
}
