package com.openclassrooms.projects.safetynet.api.crud;

import com.openclassrooms.projects.safetynet.domain.dto.crud.MedicalRecordDto;
import com.openclassrooms.projects.safetynet.service.crud.CrudService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Medical record controller.
 */
@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController extends CrudControllerBase<MedicalRecordDto> {

	/**
	 * Instantiates a new Medical record controller.
	 *
	 * @param service the service
	 */
	@Autowired
	public MedicalRecordController(final CrudService<MedicalRecordDto> service) {
		super(service);
		logger = LoggerFactory.getLogger(MedicalRecordController.class);
	}
}