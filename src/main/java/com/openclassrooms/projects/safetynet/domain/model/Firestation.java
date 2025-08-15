package com.openclassrooms.projects.safetynet.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Firestation {
// region fields
	private String address;
	private Integer station = -1;
//endregion

// region constructors
	public Firestation(String address, Integer station) {
		this.address = address;
		this.station = station;
	}

	public Firestation() {
	}
// endregion
}
