package com.openclassrooms.projects.safetynet.data.filereader;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.openclassrooms.projects.safetynet.data.mixin.FirestationMixin;
import com.openclassrooms.projects.safetynet.data.mixin.MedicalRecordMixin;
import com.openclassrooms.projects.safetynet.data.mixin.PersonMixin;
import com.openclassrooms.projects.safetynet.data.mixin.SafetyNetDataMixin;
import com.openclassrooms.projects.safetynet.domain.model.Firestation;
import com.openclassrooms.projects.safetynet.domain.model.MedicalRecord;
import com.openclassrooms.projects.safetynet.domain.model.Person;
import com.openclassrooms.projects.safetynet.domain.model.SafetyNetData;
import java.io.File;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The type Json file reader.
 */
@Component
public class JsonFileReader implements SafetyNetDataFileReader {

	private final String filePath;

	private final ObjectMapper mapper;

	/**
	 * Instantiates a new Json file reader.
	 *
	 * @param filePath the file path
	 * @param mapper   the mapper
	 */
	@Autowired
	public JsonFileReader(@Value("${jsondata.file.path}") final String filePath, final ObjectMapper mapper) {
		this.filePath = filePath;
		this.mapper = mapper;
		configureJsonMapper();
		this.registerMixins();
	}

	@Override
	public SafetyNetData readFile() {
		final SafetyNetData safetyNetData;
		final var file = new File(filePath);
		try {
			safetyNetData = mapper.readValue(file, SafetyNetData.class);
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
		return safetyNetData;
	}

	@Override
	public boolean saveFile(final SafetyNetData data) {
		try {
			final var file = new File(filePath);
			mapper.writeValue(file, data);
		} catch (final IOException e) {
			return false;
		}
		return true;
	}

	private void configureJsonMapper() {
		mapper.registerModule(new ParameterNamesModule());
		mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
	}

	private void registerMixins() {
		final SimpleModule module = new SimpleModule();
		module.setMixInAnnotation(SafetyNetData.class, SafetyNetDataMixin.class);
		module.setMixInAnnotation(Person.class, PersonMixin.class);
		module.setMixInAnnotation(MedicalRecord.class, MedicalRecordMixin.class);
		module.setMixInAnnotation(Firestation.class, FirestationMixin.class);
		mapper.registerModule(module);
	}
}
