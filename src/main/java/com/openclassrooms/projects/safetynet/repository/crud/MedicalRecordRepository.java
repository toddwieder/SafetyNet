package com.openclassrooms.projects.safetynet.repository.crud;

import com.openclassrooms.projects.safetynet.domain.interfaces.DataAdapter;
import com.openclassrooms.projects.safetynet.domain.model.MedicalRecord;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * The type Medical record repository.
 */
@Service
public class MedicalRecordRepository extends CrudRepositoryBase<MedicalRecord> {

	/**
	 * Instantiates a new Medical record repository.
	 *
	 * @param adapter the adapter
	 */
	protected MedicalRecordRepository(final DataAdapter adapter) {
		super(adapter);
	}

	@Override
	public MedicalRecord add(final MedicalRecord medicalRecord) {
		if (null == this.adapter.getMedicalRecord(medicalRecord)) {
			return adapter.addMedicalRecord(medicalRecord);
		}
		return medicalRecord;
	}

	@Override
	public boolean delete(final MedicalRecord medicalRecord) {
		return adapter.deleteMedicalRecord(medicalRecord);
	}

	@Override
	public MedicalRecord get(final MedicalRecord medicalRecord) {
		return adapter.getMedicalRecord(medicalRecord);
	}

	@Override
	public List<MedicalRecord> getAll() {
		return adapter.medicalRecords().toList();
	}

	@Override
	public MedicalRecord update(final MedicalRecord medicalRecord) {
		if (null != this.adapter.getMedicalRecord(medicalRecord)) {
			return adapter.updateMedicalRecord(medicalRecord);
		}
		return null;
	}
}

