package com.openclassrooms.projects.safetynet.repository.crud;


import com.openclassrooms.projects.safetynet.domain.interfaces.DataAdapter;
import org.springframework.stereotype.Component;

/**
 * The type Crud repository base.
 *
 * @param <T> the type parameter
 */
@Component
public abstract class CrudRepositoryBase<T> implements CrudRepository<T> {

	/**
	 * The Adapter.
	 */
	protected final DataAdapter adapter;

	/**
	 * Instantiates a new Crud repository base.
	 *
	 * @param adapter the adapter
	 */
	protected CrudRepositoryBase(final DataAdapter adapter) {
		this.adapter = adapter;
	}

	@Override
	public boolean save() {
		return adapter.saveChanges();
	}
}
