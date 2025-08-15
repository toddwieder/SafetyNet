package com.openclassrooms.projects.safetynet.data.converter;

import com.fasterxml.jackson.databind.util.StdConverter;
import com.openclassrooms.projects.safetynet.domain.model.Medication;
import java.util.List;
import java.util.stream.Collectors;

public class MedicationToStringConverter extends StdConverter<List<Medication>,
		List<String>> {

	@Override
	public List<String> convert(List<Medication> medications) {
		return medications.stream().map(m -> String.join(":", m.getDrug(),
				                  m.getDosage()))
		                  .toList();
	}
}

