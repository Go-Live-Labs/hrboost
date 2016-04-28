package com.gll.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gll.model.PinType;
import com.gll.service.PinTypeService;

@RestController
public class PinTypeController {

	private static final Logger logger = Logger.getLogger(PinTypeController.class);

	@Autowired
	PinTypeService pinTypeService;

	// -------------------display All -----------------------------------

	@RequestMapping(value = "/pinType", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PinType>> getAll() {
		List<PinType> pinTypeList = pinTypeService.getAll();
		if (pinTypeList.isEmpty()) {
			return new ResponseEntity<List<PinType>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<PinType>>(pinTypeList, HttpStatus.OK);
	}

	// -------------------display -----------------------

	@RequestMapping(value = "/pinType/{pinTypeId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PinType> display(@PathVariable("pinTypeId") int pinTypeId) {
		logger.info("Fetching PinType with pinTypeId " + pinTypeId);
		PinType pinType = pinTypeService.get(pinTypeId);
		if (pinType == null) {
			logger.info("PinType with pinTypeId " + pinTypeId + " not found");
			return new ResponseEntity<PinType>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<PinType>(pinType, HttpStatus.OK);
	}

	// -------------------Create a Record -----------------------

	@RequestMapping(value = "/pinType", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody PinType pinType, UriComponentsBuilder ucBuilder, HttpServletRequest request) {
		logger.info("Creating PinType " + pinType.getPinTypeId());
		pinType.setLocId(request.getRemoteAddr());
		pinType.setTimeUpdated(new java.util.Date());
		if (pinTypeService.get(pinType.getPinTypeId()) != null) {
			logger.info("A PinType with pinTypeId " + pinType.getPinTypeId() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		pinTypeService.post(pinType);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/annotations/pinType").buildAndExpand(pinType.getPinTypeId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Record -------------------------------

	@RequestMapping(value = "/pinType/{pinTypeId}", method = RequestMethod.PUT)
	public ResponseEntity<PinType> update(@PathVariable("pinTypeId") int pinTypeId, @RequestBody PinType pinType) {
		logger.info("Updating PinType " + pinTypeId);
		PinType oldPinType = pinTypeService.get(pinTypeId);
		logger.info("Going to update PinType : " + oldPinType);
		if (oldPinType == null) {
			logger.info("PinType with pinTypeId " + pinTypeId + " not found");
			return new ResponseEntity<PinType>(HttpStatus.NOT_FOUND);
		}

		pinTypeService.put(pinType);
		return new ResponseEntity<PinType>(pinType, HttpStatus.OK);
	}

	// ------------------- Delete a Record ----------------

	@RequestMapping(value = "/pinType/{pinTypeId}", method = RequestMethod.DELETE)
	public ResponseEntity<PinType> delete(@PathVariable("pinTypeId") int pinTypeId) {
		logger.info("Fetching & Deleting PinType with pinTypeId " + pinTypeId);
		PinType pinType = pinTypeService.get(pinTypeId);
		if (pinType == null) {
			logger.info("Unable to delete. PinType with pinTypeId " + pinTypeId + " not found");
			return new ResponseEntity<PinType>(HttpStatus.NOT_FOUND);
		}
		pinTypeService.delete(pinTypeId);
		return new ResponseEntity<PinType>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All ---------------

	@RequestMapping(value = "/pinType", method = RequestMethod.DELETE)
	public ResponseEntity<PinType> deleteAll() {
		logger.info("Deleting All PinTypes");
		pinTypeService.delete(1);
		return new ResponseEntity<PinType>(HttpStatus.NO_CONTENT);
	}
}