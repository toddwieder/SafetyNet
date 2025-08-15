package com.openclassrooms.projects.safetynet.data.filereader;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.openclassrooms.projects.safetynet.data.mixin.SafetyNetDataMixin;
import com.openclassrooms.projects.safetynet.domain.model.Firestation;
import com.openclassrooms.projects.safetynet.domain.model.MedicalRecord;
import com.openclassrooms.projects.safetynet.domain.model.Person;
import com.openclassrooms.projects.safetynet.domain.model.SafetyNetData;
import com.openclassrooms.projects.safetynet.data.mixin.FirestationMixin;
import com.openclassrooms.projects.safetynet.data.mixin.MedicalRecordMixin;
import com.openclassrooms.projects.safetynet.data.mixin.PersonMixin;
import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JsonFileReader implements SafetyNetDataFileReader {

	private final String filePath;

	private final ObjectMapper mapper;

	@Autowired
	public JsonFileReader(@Value("${jsondata.file.path}") String filePath, ObjectMapper mapper) {
		this.filePath = filePath;
		this.mapper = mapper;
		this.configureJsonMapper();
		registerMixins();
	}

	@Override
	public SafetyNetData readFile() {
		SafetyNetData safetyNetData;
		var file = new File(this.filePath);
		try {
			safetyNetData = this.mapper.readValue(file, SafetyNetData.class);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return safetyNetData;
	}

	@Override
	public boolean saveFile(SafetyNetData data) {
		try {
			var file = new File(this.filePath);
			this.mapper.writeValue(file, data);
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	private void configureJsonMapper() {
		this.mapper.registerModule(new ParameterNamesModule());
		this.mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
		this.mapper.enable(SerializationFeature.INDENT_OUTPUT);
	}

	private void registerMixins() {
		SimpleModule module = new SimpleModule();
		module.setMixInAnnotation(SafetyNetData.class, SafetyNetDataMixin.class);
		module.setMixInAnnotation(Person.class, PersonMixin.class);
		module.setMixInAnnotation(MedicalRecord.class, MedicalRecordMixin.class);
		module.setMixInAnnotation(Firestation.class, FirestationMixin.class);
		this.mapper.registerModule(module);
	}
}
