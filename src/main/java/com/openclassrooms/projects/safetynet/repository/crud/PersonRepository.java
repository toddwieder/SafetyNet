package com.openclassrooms.projects.safetynet.repository.crud;

import com.openclassrooms.projects.safetynet.domain.interfaces.DataAdapter;
import com.openclassrooms.projects.safetynet.domain.model.Person;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PersonRepository extends CrudRepositoryBase<Person> {

	protected PersonRepository(DataAdapter adapter) {
		super(adapter);
	}

	// region public methods
	@Override
	public Person add(Person person) {
		if (this.adapter.getPerson(person) == null) {
		return this.adapter.addPerson(person);
		}
		return person;
	}

	@Override
	public boolean delete(Person person) {
		return this.adapter.deletePerson(person);
	}

	@Override
	public Person get(Person person) {
		return this.adapter.getPerson(person);
	}

	@Override
	public List<Person> getAll() {
		return this.adapter.persons().toList();
	}

	@Override
	public Person update(Person person) {
		if (this.adapter.getPerson(person) != null) {
		return this.adapter.updatePerson(person);
		}
		return null;
	}
// endregion
}

