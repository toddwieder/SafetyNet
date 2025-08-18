package com.openclassrooms.projects.safetynet.data.filereader;

import com.openclassrooms.projects.safetynet.domain.model.SafetyNetData;

/**
 * The interface Safety net data file reader.
 */
public interface SafetyNetDataFileReader {
	/**
	 * Read file safety net data.
	 *
	 * @return the safety net data
	 */
	SafetyNetData readFile();

	/**
	 * Save data to file .
	 *
	 * @param data the data
	 * @return the boolean success
	 */
	boolean saveFile(SafetyNetData data);
}
