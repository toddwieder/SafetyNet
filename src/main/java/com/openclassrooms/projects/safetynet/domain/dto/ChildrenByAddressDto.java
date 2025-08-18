package com.openclassrooms.projects.safetynet.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * The type Children by address dto.
 */
@Setter
@Getter
public class ChildrenByAddressDto {

	private List<PersonInfoDto> children;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<PersonInfoDto> householdMembers;

	/**
	 * Instantiates a new Children by address dto.
	 *
	 * @param children         the children
	 * @param householdMembers the household members
	 */
	public ChildrenByAddressDto(final List<PersonInfoDto> children,
	                            final List<PersonInfoDto> householdMembers) {
		this.children = children;
		this.householdMembers = householdMembers;
	}

}
