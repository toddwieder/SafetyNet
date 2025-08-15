package com.openclassrooms.projects.safetynet.domain.mapper;

import com.openclassrooms.projects.safetynet.domain.dto.crud.PersonDto;
import com.openclassrooms.projects.safetynet.domain.model.Person;
import com.openclassrooms.projects.safetynet.domain.interfaces.CrudMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper implements CrudMapper<Person, PersonDto> {

	public Person toModel(PersonDto dto) {
		var person = new Person();
		person.setFirstName(dto.getFirstName());
		person.setLastName(dto.getLastName());
		person.setAddress(dto.getAddress());
		person.setCity(dto.getCity());
		person.setZip(dto.getZip());
		person.setPhone(dto.getPhone());
		person.setEmail(dto.getEmail());
		return person;
	}


	public PersonDto toDto(Person model) {
		var dto = new PersonDto();
		dto.setFirstName(model.getFirstName());
		dto.setLastName(model.getLastName());
		dto.setAddress(model.getAddress());
		dto.setCity(model.getCity());
		dto.setZip(model.getZip());
		dto.setPhone(model.getPhone());
		dto.setEmail(model.getEmail());
		return dto;
	}
}

