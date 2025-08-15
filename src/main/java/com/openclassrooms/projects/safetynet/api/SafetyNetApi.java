package com.openclassrooms.projects.safetynet.api;

import com.openclassrooms.projects.safetynet.service.SafetyNetService;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SafetyNetApi {

// region fields
	private final SafetyNetService service;
	Logger logger = LoggerFactory.getLogger(SafetyNetApi.class);
//endregion

// region constructors
	@Autowired
	public SafetyNetApi(SafetyNetService safetyNetService) {
		this.service = safetyNetService;
	}
// endregion

// region public methods
	@GetMapping("/childAlert")
	public ResponseEntity getChildrenByAddress(@RequestParam("address") String address) {
		try {
			var response = this.service.getChildrenByAddress(address);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return logAndReturnError(e);
		}
	}

	@GetMapping("/communityEmail")
	public ResponseEntity getEmailAddressesByCity(@RequestParam("city") String city) {
		try {
			var response = this.service.getEmailAddressesByCity(city);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return logAndReturnError(e);
		}
	}

	@GetMapping("/flood/stations")
	public ResponseEntity getHouseholdsByFirestations(@RequestParam("stations") List<Integer> stationNumbers) {
		try {
			var response = this.service.getHouseholdsByFirestations(stationNumbers);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return logAndReturnError(e);
		}
	}

	@GetMapping("/fire")
	public ResponseEntity getPersonsAndFirestationByAddress(@RequestParam("address") String address) {
		try {
			var response = this.service.getPersonsAndFirestationByAddress(address);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return logAndReturnError(e);
		}
	}

	@GetMapping("/personInfo")
	public ResponseEntity getPersonsByLastName(@RequestParam("lastName") String lastName) {
		try {
			var response = this.service.getPersonsByLastName(lastName);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return logAndReturnError(e);
		}
	}

	@GetMapping("/firestation")
	public ResponseEntity getPersonsByStationNumber(@RequestParam("stationNumber") int stationNumber) {
		try {
			var response = this.service.getPersonsByStationNumber(stationNumber);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return logAndReturnError(e);
		}
	}

	@GetMapping("/phoneAlert")
	public ResponseEntity getPhoneNumbersByFirestation(@RequestParam("firestation") int stationNumber) {
		try {
			var response = this.service.getPhoneNumbersByStationNumber(stationNumber);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return logAndReturnError(e);
		}
	}
// endregion

// region private methods
	@NotNull
	private ResponseEntity logAndReturnError(Exception e) {
		this.logger.error(e.getMessage());
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
// endregion
}


