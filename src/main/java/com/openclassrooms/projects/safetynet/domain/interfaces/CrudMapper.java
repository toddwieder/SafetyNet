package com.openclassrooms.projects.safetynet.domain.interfaces;

import org.springframework.stereotype.Component;

/**
 * The interface Crud mapper.
 *
 * @param <T> the type parameter
 * @param <D> the type parameter
 */
@Component
public interface CrudMapper<T, D extends CrudDto> {
	/**
	 * To dto d.
	 *
	 * @param model the model
	 * @return the dto
	 */
	D toDto(T model);

	/**
	 * To model T.
	 *
	 * @param dto the dto
	 * @return the model T
	 */
	T toModel(D dto);
}