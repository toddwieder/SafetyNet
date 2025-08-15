package com.openclassrooms.projects.safetynet.data.filereader;

import com.openclassrooms.projects.safetynet.domain.model.SafetyNetData;

public interface SafetyNetDataFileReader {
	SafetyNetData readFile();
	boolean saveFile(SafetyNetData data);
}
