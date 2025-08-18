package com.openclassrooms.projects.safetynet.service.crud;

import com.openclassrooms.projects.safetynet.domain.dto.crud.MedicalRecordDto;
import com.openclassrooms.projects.safetynet.domain.interfaces.CrudMapper;
import com.openclassrooms.projects.safetynet.domain.model.MedicalRecord;
import com.openclassrooms.projects.safetynet.repository.crud.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Medical record service.
 */
@Service
public class MedicalRecordService extends CrudServiceBase<MedicalRecord, MedicalRecordDto> {
	/**
	 * Instantiates a new Medical record service.
	 *
	 * @param mapper     the mapper
	 * @param repository the repository
	 */
	@Autowired
	public MedicalRecordService(final CrudMapper<MedicalRecord, MedicalRecordDto> mapper,
	                            final CrudRepository<MedicalRecord> repository) {
		super(mapper, repository);
	}
}
