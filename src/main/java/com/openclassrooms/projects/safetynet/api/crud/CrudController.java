package com.openclassrooms.projects.safetynet.api.crud;

import com.openclassrooms.projects.safetynet.domain.interfaces.CrudDto;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CrudController<D extends CrudDto> {
	@PutMapping
	ResponseEntity<D> update(@RequestBody D dto);

	@PostMapping("/save")
	ResponseEntity<Boolean> save();

	@GetMapping("/getAll")
	ResponseEntity<List<D>> getAll();

	@DeleteMapping
	ResponseEntity<Boolean> delete(@RequestBody D dto);

	@PostMapping
	ResponseEntity<D> add(@RequestBody D dto);
}
