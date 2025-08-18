package com.openclassrooms.projects.safetynet.domain.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Households by address dto.
 */
@Getter
@Setter
public class HouseholdsByAddressDto {
	private String address;

	private List<PersonInfoDto> persons;

	/**
	 * Instantiates a new Households by address dto.
	 *
	 * @param address the address
	 * @param persons the persons
	 */
	public HouseholdsByAddressDto(final String address, final List<PersonInfoDto> persons) {
		this.address = address;
		this.persons = persons;
	}
}
