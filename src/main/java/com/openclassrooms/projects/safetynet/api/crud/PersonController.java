package com.openclassrooms.projects.safetynet.api.crud;

import com.openclassrooms.projects.safetynet.domain.dto.crud.PersonDto;
import com.openclassrooms.projects.safetynet.service.crud.CrudService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController extends CrudControllerBase<PersonDto> {

// region constructors
	@Autowired
	public PersonController(CrudService<PersonDto> service) {
		super(service);
		this.logger = LoggerFactory.getLogger(PersonController.class);
	}
// endregion
}
