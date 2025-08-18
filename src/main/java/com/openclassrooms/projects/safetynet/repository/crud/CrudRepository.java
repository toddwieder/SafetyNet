package com.openclassrooms.projects.safetynet.repository.crud;

import java.util.List;
import org.springframework.stereotype.Component;

/**
 * The interface Crud repository.
 *
 * @param <T> the type parameter
 */
@Component
public interface CrudRepository<T> {
	/**
	 * Add t.
	 *
	 * @param type the type
	 * @return the t
	 */
	T add(T type);

	/**
	 * Delete boolean.
	 *
	 * @param type the type
	 * @return the boolean
	 */
	boolean delete(T type);

	/**
	 * Get t.
	 *
	 * @param type the type
	 * @return the t
	 */
	T get(T type);

	/**
	 * Gets all.
	 *
	 * @return the all
	 */
	List<T> getAll();

	/**
	 * Save boolean.
	 *
	 * @return the boolean
	 */
	boolean save();

	/**
	 * Update t.
	 *
	 * @param type the type
	 * @return the t
	 */
	T update(T type);
}
