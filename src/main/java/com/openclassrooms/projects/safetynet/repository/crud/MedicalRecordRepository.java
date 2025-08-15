package com.openclassrooms.projects.safetynet.repository.crud;

import com.openclassrooms.projects.safetynet.domain.interfaces.DataAdapter;
import com.openclassrooms.projects.safetynet.domain.model.MedicalRecord;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordRepository extends CrudRepositoryBase<MedicalRecord> {

	protected MedicalRecordRepository(DataAdapter adapter) {
		super(adapter);
	}

	// region public methods
	@Override
	public MedicalRecord add(MedicalRecord medicalRecord) {
		if (this.adapter.getMedicalRecord(medicalRecord) == null) {
			return this.adapter.addMedicalRecord(medicalRecord);
		}
		return medicalRecord;
	}

	@Override
	public boolean delete(MedicalRecord medicalRecord) {
		return this.adapter.deleteMedicalRecord(medicalRecord);
	}

	@Override
	public MedicalRecord get(MedicalRecord medicalRecord) {
		return this.adapter.getMedicalRecord(medicalRecord);
	}

	@Override
	public List<MedicalRecord> getAll() {
		return this.adapter.medicalRecords().toList();
	}

	@Override
	public MedicalRecord update(MedicalRecord medicalRecord) {
		if (this.adapter.getMedicalRecord(medicalRecord) != null) {
			return this.adapter.updateMedicalRecord(medicalRecord);
		}
		return null;
	}
}

