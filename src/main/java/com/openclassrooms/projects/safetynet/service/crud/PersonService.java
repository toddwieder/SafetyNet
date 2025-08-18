package com.openclassrooms.projects.safetynet.service.crud;

import com.openclassrooms.projects.safetynet.domain.dto.crud.PersonDto;
import com.openclassrooms.projects.safetynet.domain.interfaces.CrudMapper;
import com.openclassrooms.projects.safetynet.domain.model.Person;
import com.openclassrooms.projects.safetynet.repository.crud.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Person service.
 */
@Service
public class PersonService extends CrudServiceBase<Person, PersonDto> {
	/**
	 * Instantiates a new Person service.
	 *
	 * @param mapper     the mapper
	 * @param repository the repository
	 */
	@Autowired
	public PersonService(final CrudMapper<Person, PersonDto> mapper, final CrudRepository<Person> repository) {
		super(mapper, repository);
	}
}
