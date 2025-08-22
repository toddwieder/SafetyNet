package com.openclassrooms.projects.safetynet.api.crud;

import com.openclassrooms.projects.safetynet.domain.interfaces.CrudDto;
import com.openclassrooms.projects.safetynet.service.crud.CrudService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * The type Crud controller base.
 *
 * @param <D> the type parameter
 */
public abstract class CrudControllerBase<D extends CrudDto> implements CrudController<D> {

	private final CrudService<D> crudService;
	/**
	 * The Logger.
	 */
	Logger logger;

	/**
	 * Instantiates a new Crud controller base.
	 *
	 * @param crudService the crud service
	 */
	protected CrudControllerBase(CrudService<D> crudService, Logger logger) {
		this.crudService = crudService;
		this.logger = logger;
	}

	@PostMapping
	@Override
	public ResponseEntity add(@Valid @RequestBody D dto) {
		try {
			var response = crudService.add(dto);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return logAndReturnError(e);
		}
	}

	@DeleteMapping
	@Override
	public ResponseEntity delete(@RequestBody D dto) {
		try {
			var response = crudService.delete(dto);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return logAndReturnError(e);
		}
	}

	@GetMapping("/getAll")
	@Override
	public ResponseEntity getAll() {
		try {
			var response = crudService.getAll();
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return logAndReturnError(e);
		}
	}

	/**
	 * Handle exception problem detail.
	 *
	 * @param ex the ex
	 * @return the problem detail
	 */
	@ExceptionHandler(Exception.class)
	public ProblemDetail handleException(Exception ex) {
		return ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
	}

	/**
	 * Handle validation exception problem detail.
	 *
	 * @param ex the ex
	 * @return the problem detail
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ProblemDetail handleValidationException(MethodArgumentNotValidException ex) {
		var result = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,
				ex.getMessage());
		result.setTitle("Validation Error");
		return result;
	}

	@PostMapping("/save")
	@Override
	public ResponseEntity save() {
		try {
			return new ResponseEntity<>(crudService.save(), HttpStatus.OK);
		} catch (Exception e) {
			return logAndReturnError(e);
		}
	}

	@PutMapping
	@Override
	public ResponseEntity update(@RequestBody D dto) {
		try {
			D updatedEntity = crudService.update(dto);
			return new ResponseEntity<>(updatedEntity, HttpStatus.OK);
		} catch (Exception e) {
			return logAndReturnError(e);
		}
	}

	private ResponseEntity<Exception> logAndReturnError(Exception e) {
		logger.error(e.getMessage());
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
