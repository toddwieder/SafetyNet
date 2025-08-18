package com.openclassrooms.projects.safetynet.service.crud;

import com.openclassrooms.projects.safetynet.domain.interfaces.CrudDto;
import com.openclassrooms.projects.safetynet.domain.interfaces.CrudMapper;
import com.openclassrooms.projects.safetynet.repository.crud.CrudRepository;
import java.util.List;

/**
 * The type Crud service base.
 *
 * @param <T> the type parameter
 * @param <D> the type parameter
 */
public abstract class CrudServiceBase<T, D extends CrudDto> implements CrudService<D> {

	private final CrudMapper<T, D> mapper;

	private final CrudRepository<T> repository;

	/**
	 * Instantiates a new Crud service base.
	 *
	 * @param mapper     the mapper
	 * @param repository the repository
	 */
	protected CrudServiceBase(final CrudMapper<T, D> mapper, final CrudRepository<T> repository) {
		this.mapper = mapper;
		this.repository = repository;
	}

	@Override
	public D add(final D dto) {
		final var model = mapper.toModel(dto);
		final T addedEntity = repository.add(model);
		this.save();
		return mapper.toDto(addedEntity);
	}

	@Override
	public boolean delete(final D dto) {
		final var model = mapper.toModel(dto);
		final boolean isDeleted = repository.delete(model);
		this.save();
		return isDeleted;
	}

	@Override
	public D get(final D dto) {
		final var model = mapper.toModel(dto);
		return mapper.toDto(repository.get(model));
	}

	@Override
	public List<D> getAll() {
		final var model = repository.getAll();
		return model.stream().map(mapper::toDto).toList();
	}

	@Override
	public boolean save() {
		return repository.save();
	}

	@Override
	public D update(final D dto) {
		final var model = mapper.toModel(dto);
		final T updatedEntity = repository.update(model);
		this.save();
		return mapper.toDto(updatedEntity);
	}
}
