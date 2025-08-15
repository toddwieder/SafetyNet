package com.openclassrooms.projects.safetynet.api.crud;

import com.openclassrooms.projects.safetynet.domain.dto.crud.MedicalRecordDto;
import com.openclassrooms.projects.safetynet.service.crud.CrudService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController extends CrudControllerBase<MedicalRecordDto> {

// region constructors
	@Autowired
	public MedicalRecordController(CrudService<MedicalRecordDto> service) {
		super(service);
		this.logger = LoggerFactory.getLogger(MedicalRecordController.class);
	}
// endregion
}