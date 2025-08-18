package com.openclassrooms.projects.safetynet.service.crud;

import com.openclassrooms.projects.safetynet.domain.dto.crud.FirestationDto;
import com.openclassrooms.projects.safetynet.domain.interfaces.CrudMapper;
import com.openclassrooms.projects.safetynet.domain.model.Firestation;
import com.openclassrooms.projects.safetynet.repository.crud.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Firestation service.
 */
@Service
public class FirestationService extends CrudServiceBase<Firestation, FirestationDto> {
	/**
	 * Instantiates a new Firestation service.
	 *
	 * @param mapper     the mapper
	 * @param repository the repository
	 */
	@Autowired
	public FirestationService(CrudMapper<Firestation, FirestationDto> mapper,
	                          CrudRepository<Firestation> repository) {
		super(mapper, repository);
	}
}
