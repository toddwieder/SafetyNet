package com.openclassrooms.projects.safetynet.service.crud;

import com.openclassrooms.projects.safetynet.domain.dto.crud.MedicalRecordDto;
import com.openclassrooms.projects.safetynet.domain.interfaces.CrudMapper;
import com.openclassrooms.projects.safetynet.domain.model.MedicalRecord;
import com.openclassrooms.projects.safetynet.repository.crud.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService extends CrudServiceBase<MedicalRecord, MedicalRecordDto> {
	@Autowired
	public MedicalRecordService(CrudMapper<MedicalRecord, MedicalRecordDto> mapper,
	                            CrudRepository<MedicalRecord> repository) {
		super(mapper, repository);
	}
}
