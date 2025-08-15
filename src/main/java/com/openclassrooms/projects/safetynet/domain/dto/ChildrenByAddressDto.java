package com.openclassrooms.projects.safetynet.domain.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChildrenByAddressDto {
// region fields
	private List<PersonInfoDto> children;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<PersonInfoDto> householdMembers;
//endregion

// region constructors
	public ChildrenByAddressDto(List<PersonInfoDto> children,
	                            List<PersonInfoDto> householdMembers) {
		this.children = children;
		this.householdMembers = householdMembers;
	}
// endregion
}
