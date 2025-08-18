package com.openclassrooms.projects.safetynet.service.crud;

import com.openclassrooms.projects.safetynet.domain.interfaces.CrudDto;
import java.util.List;

/**
 * The interface Crud service.
 *
 * @param <D> the type parameter
 */
public interface CrudService<D extends CrudDto> {
	/**
	 * Add d.
	 *
	 * @param dto the dto
	 * @return the added dto
	 * */
	D add(D dto);

	/**
	 * Delete boolean.
	 *
	 * @param dto the dto
	 * @return the boolean
	 */
	boolean delete(D dto);

	/**
	 * Get dto entity d.
	 *
	 * @param dto the dto
	 * @return the response dto
	 */
	D get(D dto);

	/**
	 * Gets all dtos.
	 *
	 * @return all the dtos
	 */
	List<D> getAll();

	/**
	 * Save changes.
	 *
	 * @return boolean success
	 */
	boolean save();

	/**
	 * Update d.
	 *
	 * @param dto the dto
	 * @return the updated dto
	 */
	D update(D dto);
}
