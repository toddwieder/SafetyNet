package com.openclassrooms.projects.safetynet.api.crud;

import com.openclassrooms.projects.safetynet.domain.interfaces.CrudDto;
import com.openclassrooms.projects.safetynet.service.crud.CrudService;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class CrudControllerBase<D extends CrudDto> implements CrudController<D> {
// region fields
	private final CrudService<D> crudService;
	Logger logger;
//endregion

// region constructors
	protected CrudControllerBase(CrudService<D> crudService) {
		this.crudService = crudService;
	}
// endregion

// region public methods
@PostMapping
@Override
public final ResponseEntity add(@RequestBody D dto) {
		try {
			var response = this.crudService.add(dto);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return logAndReturnError(e);
		}
	}

	@DeleteMapping
	@Override
	public ResponseEntity delete(@RequestBody D dto) {
		try {
			var response = this.crudService.delete(dto);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return logAndReturnError(e);
		}
	}

	@GetMapping("/getAll")
	@Override
	public ResponseEntity getAll() {
		try {
			var response = this.crudService.getAll();
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return logAndReturnError(e);
		}
	}

	@PostMapping("/save")
	@Override
	public ResponseEntity save() {
		try {
			return new ResponseEntity<>(this.crudService.save(), HttpStatus.OK);
		} catch (Exception e) {
			return logAndReturnError(e);
		}
	}

	@PutMapping
	@Override
	public ResponseEntity update(@RequestBody D dto) {
		try {
			D updatedEntity = this.crudService.update(dto);
			return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
		} catch (Exception e) {
			return logAndReturnError(e);
		}
	}
// endregion

	private ResponseEntity<Exception> logAndReturnError(Exception e) {
		logger.error(e.getMessage());
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
