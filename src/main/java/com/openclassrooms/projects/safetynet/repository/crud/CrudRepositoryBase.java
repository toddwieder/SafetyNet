package com.openclassrooms.projects.safetynet.repository.crud;


import com.openclassrooms.projects.safetynet.domain.interfaces.DataAdapter;
import org.springframework.stereotype.Component;

@Component
public abstract class CrudRepositoryBase<T> implements CrudRepository<T> {

	protected final DataAdapter adapter;

	protected CrudRepositoryBase(DataAdapter adapter) {
		this.adapter = adapter;
	}

	@Override
	public boolean save() {
		return this.adapter.saveChanges();
	}
}
