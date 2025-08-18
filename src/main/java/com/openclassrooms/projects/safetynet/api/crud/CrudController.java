package com.openclassrooms.projects.safetynet.api.crud;

import com.openclassrooms.projects.safetynet.domain.interfaces.CrudDto;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Crud Controller
 *
 * @param <D> of CrudDto
 */
public interface CrudController<D extends CrudDto> {
	/**
	 * Crud Update
	 *
	 * @param dto request
	 * @return updated entity
	 */
	@PutMapping
	ResponseEntity<D> update(@RequestBody D dto);

	/**
	 * Crud Save
	 *
	 * @return boolean success
	 */
	@PostMapping("/save")
	ResponseEntity<Boolean> save();

	/**
	 * Gets all entities
	 *
	 * @return List D  the entity
	 */
	@GetMapping("/getAll")
	ResponseEntity<List<D>> getAll();

	/**
	 * Delete request entity.
	 *
	 * @param dto the request
	 * @return the response entity
	 */
	@DeleteMapping
	ResponseEntity<Boolean> delete(@RequestBody D dto);

	/**
	 * Add request entity.
	 *
	 * @param dto the request
	 * @return the response entity
	 */
	@PostMapping
	ResponseEntity<D> add(@RequestBody D dto);
}
