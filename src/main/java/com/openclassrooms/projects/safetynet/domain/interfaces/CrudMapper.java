package com.openclassrooms.projects.safetynet.domain.interfaces;

import org.springframework.stereotype.Component;

@Component
public interface CrudMapper<T, D extends CrudDto> {
	T toModel (D dto);
	D toDto (T model);
}