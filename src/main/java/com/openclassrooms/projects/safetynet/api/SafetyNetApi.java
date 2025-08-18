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

/**
 * The type Safety net api.
 */
@RestController
@RequestMapping("/")
public class SafetyNetApi {

	private final SafetyNetService service;
	/**
	 * The Logger.
	 */
	Logger logger = LoggerFactory.getLogger(SafetyNetApi.class);

	/**
	 * Instantiates a new Safety net api.
	 *
	 * @param safetyNetService the safety net service
	 */
	@Autowired
	public SafetyNetApi(final SafetyNetService safetyNetService) {
		service = safetyNetService;
	}

	/**
	 * Gets children by address.
	 *
	 * @param address the address
	 * @return the children by address
	 */
	@GetMapping("/childAlert")
	public ResponseEntity getChildrenByAddress(@RequestParam("address") final String address) {
		try {
			final var response = service.getChildrenByAddress(address);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (final Exception e) {
			return this.logAndReturnError(e);
		}
	}

	/**
	 * Gets email addresses by city.
	 *
	 * @param city the city
	 * @return the email addresses by city
	 */
	@GetMapping("/communityEmail")
	public ResponseEntity getEmailAddressesByCity(@RequestParam("city") final String city) {
		try {
			final var response = service.getEmailAddressesByCity(city);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (final Exception e) {
			return this.logAndReturnError(e);
		}
	}

	/**
	 * Gets households by firestations.
	 *
	 * @param stationNumbers the station numbers
	 * @return the households by firestations
	 */
	@GetMapping("/flood/stations")
	public ResponseEntity getHouseholdsByFirestations(@RequestParam("stations") final List<Integer> stationNumbers) {
		try {
			final var response = service.getHouseholdsByFirestations(stationNumbers);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (final Exception e) {
			return this.logAndReturnError(e);
		}
	}

	/**
	 * Gets persons and firestation by address.
	 *
	 * @param address the address
	 * @return the persons and firestation by address
	 */
	@GetMapping("/fire")
	public ResponseEntity getPersonsAndFirestationByAddress(@RequestParam("address") final String address) {
		try {
			final var response = service.getPersonsAndFirestationByAddress(address);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (final Exception e) {
			return this.logAndReturnError(e);
		}
	}

	/**
	 * Gets persons by last name.
	 *
	 * @param lastName the last name
	 * @return the persons by last name
	 */
	@GetMapping("/personInfo")
	public ResponseEntity getPersonsByLastName(@RequestParam("lastName") final String lastName) {
		try {
			final var response = service.getPersonsByLastName(lastName);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (final Exception e) {
			return this.logAndReturnError(e);
		}
	}

	/**
	 * Gets persons by station number.
	 *
	 * @param stationNumber the station number
	 * @return the persons by station number
	 */
	@GetMapping("/firestation")
	public ResponseEntity getPersonsByStationNumber(@RequestParam("stationNumber") final int stationNumber) {
		try {
			final var response = service.getPersonsByStationNumber(stationNumber);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (final Exception e) {
			return this.logAndReturnError(e);
		}
	}

	/**
	 * Gets phone numbers by firestation.
	 *
	 * @param stationNumber the station number
	 * @return the phone numbers by firestation
	 */
	@GetMapping("/phoneAlert")
	public ResponseEntity getPhoneNumbersByFirestation(@RequestParam("firestation") final int stationNumber) {
		try {
			final var response = service.getPhoneNumbersByStationNumber(stationNumber);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (final Exception e) {
			return this.logAndReturnError(e);
		}
	}

	@NotNull
	private ResponseEntity logAndReturnError(final Exception e) {
		logger.error(e.getMessage());
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}


