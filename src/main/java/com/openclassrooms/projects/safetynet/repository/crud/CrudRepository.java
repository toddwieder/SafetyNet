package com.openclassrooms.projects.safetynet.repository.crud;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public interface CrudRepository<T> {
	List<T> getAll();

	T get(T type);

	T add(T type);

	T update(T type);

	boolean delete(T type);

	boolean save();
}
