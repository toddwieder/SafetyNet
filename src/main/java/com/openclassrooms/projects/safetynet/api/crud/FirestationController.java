package com.openclassrooms.projects.safetynet.api.crud;

import com.openclassrooms.projects.safetynet.domain.dto.crud.FirestationDto;
import com.openclassrooms.projects.safetynet.service.crud.CrudService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Firestation controller.
 */
@RestController
@RequestMapping("/firestation")
public class FirestationController extends CrudControllerBase<FirestationDto> {

	/**
	 * Instantiates a new Firestation controller.
	 *
	 * @param service the service
	 */
	@Autowired
	public FirestationController(CrudService<FirestationDto> service) {
		super(service);
		this.logger = LoggerFactory.getLogger(FirestationController.class);
	}
}