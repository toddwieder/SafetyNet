package com.openclassrooms.projects.safetynet.repository.crud;

import com.openclassrooms.projects.safetynet.domain.interfaces.DataAdapter;
import com.openclassrooms.projects.safetynet.domain.model.Firestation;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class FirestationRepository extends CrudRepositoryBase<Firestation> implements CrudRepository<Firestation> {

	protected FirestationRepository(DataAdapter adapter) {
		super(adapter);
	}

	// region public methods
	@Override
	public Firestation add(Firestation firestation) {
		if (this.adapter.getFirestation(firestation) == null) {
			return this.adapter.addFirestation(firestation);
		}
		return firestation;
	}

	@Override
	public boolean delete(Firestation firestation) {
		return this.adapter.deleteFirestation(firestation);
	}

	@Override
	public Firestation get(Firestation firestation) {
		return this.adapter.getFirestation(firestation);
	}

	@Override
	public List<Firestation> getAll() {
		return this.adapter.firestations().toList();
	}

	@Override
	public Firestation update(Firestation firestation) {
		if (this.adapter.getFirestation(firestation) != null) {
			return this.adapter.updateFirestation(firestation);
		}
		return null;
	}
// endregion
}
