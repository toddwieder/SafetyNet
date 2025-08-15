package com.openclassrooms.projects.safetynet.domain.utility;

import com.openclassrooms.projects.safetynet.domain.interfaces.FirstLastName;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public enum ModelHelper {
	;

// region public methods
	public static Integer getAge(Date birthday) {
		return Period.between(birthday.toInstant().atZone(ZoneId.systemDefault())
		                              .toLocalDate(), LocalDate.now()).getYears();
	}

	public static String getFullName(FirstLastName person) {
		return person.getFirstName() + " " + person.getLastName();
	}
// endregion
}
