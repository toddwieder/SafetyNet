package com.openclassrooms.projects.safetynet.data.mixin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.openclassrooms.projects.safetynet.domain.model.Firestation;
import com.openclassrooms.projects.safetynet.domain.model.MedicalRecord;
import com.openclassrooms.projects.safetynet.domain.model.Person;
import com.openclassrooms.projects.safetynet.domain.model.SafetyNetData;
import java.util.List;
import org.springframework.boot.jackson.JsonMixin;

@JsonMixin(SafetyNetData.class)
public class SafetyNetDataMixin {
	public List<Person> persons;
	public List<Firestation> firestations;
	@JsonProperty("medicalrecords")
	public List<MedicalRecord> medicalRecords;
}
