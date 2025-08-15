package com.openclassrooms.projects.safetynet.service.crud;

import com.openclassrooms.projects.safetynet.domain.interfaces.CrudDto;
import com.openclassrooms.projects.safetynet.domain.interfaces.CrudMapper;
import com.openclassrooms.projects.safetynet.repository.crud.CrudRepository;
import java.util.List;

public abstract class CrudServiceBase<T, D extends CrudDto> implements CrudService<D> {

	private final CrudMapper<T, D> mapper;
	private final CrudRepository<T> repository;

	protected CrudServiceBase(CrudMapper<T, D> mapper, CrudRepository<T> repository) {
		this.mapper = mapper;
		this.repository = repository;
	}

	@Override
	public List<D> getAll() {
		var model = this.repository.getAll();
		return model.stream().map(this.mapper::toDto).toList();
	}

	@Override
	public D get(D dto) {
		var model = this.mapper.toModel(dto);
		return this.mapper.toDto(this.repository.get(model));
	}

	@Override
	public D add(D dto){
		var model = this.mapper.toModel(dto);
			T addedEntity = this.repository.add(model);
		save();
		return this.mapper.toDto(addedEntity) ;
	}

	@Override
	public D update(D dto){
		var model = this.mapper.toModel(dto);
		T updatedEntity = this.repository.update(model);
		save();
		return this.mapper.toDto(updatedEntity) ;
	}

	@Override
	public boolean delete(D dto){
		var model = this.mapper.toModel(dto);
		boolean isDeleted = this.repository.delete(model);
		save();
		return isDeleted;
	}

	@Override
	public boolean save() {
		return this.repository.save();
	}
}
