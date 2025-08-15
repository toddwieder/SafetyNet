package com.openclassrooms.projects.safetynet.domain.mapper;

import com.openclassrooms.projects.safetynet.domain.model.Firestation;
import com.openclassrooms.projects.safetynet.domain.dto.crud.FirestationDto;
import com.openclassrooms.projects.safetynet.domain.interfaces.CrudMapper;
import org.springframework.stereotype.Component;

@Component
public class FirestationMapper implements CrudMapper<Firestation, FirestationDto> {

	public Firestation toModel(FirestationDto dto) {
		var firestation = new Firestation();
		firestation.setAddress(dto.getAddress());
		firestation.setStation(dto.getStation());
		return firestation;
	}


	public FirestationDto toDto(Firestation model) {
		var dto = new FirestationDto();
		dto.setAddress(model.getAddress());
		dto.setStation(model.getStation());
		return dto;
	}
}

