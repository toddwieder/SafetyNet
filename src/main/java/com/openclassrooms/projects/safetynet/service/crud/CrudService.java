package com.openclassrooms.projects.safetynet.service.crud;

import com.openclassrooms.projects.safetynet.domain.interfaces.CrudDto;
import java.util.List;

public interface CrudService<D extends CrudDto> {
	List<D> getAll();

	D add(D dto);

	D get(D dto);

	D update(D dto);

	boolean delete( D dto);

	boolean save();
}
