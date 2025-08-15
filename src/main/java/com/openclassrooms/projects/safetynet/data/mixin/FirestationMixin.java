package com.openclassrooms.projects.safetynet.data.mixin;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

public abstract class FirestationMixin {
	private String address;

	@JsonSerialize(using = ToStringSerializer.class)
	private Integer station;
}
