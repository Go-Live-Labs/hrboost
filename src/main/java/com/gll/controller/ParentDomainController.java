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

import com.gll.model.ParentDomain;
import com.gll.service.ParentDomainService;

@RestController
public class ParentDomainController {

	private static final Logger logger = Logger.getLogger(ParentDomainController.class);

	@Autowired
	ParentDomainService parentDomainService;

	// -------------------display All -----------------------------------

	@RequestMapping(value = "/annotations/parentDomain", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ParentDomain>> displayAll() {
		List<ParentDomain> parentDomainList = parentDomainService.displayAll();
		if (parentDomainList.isEmpty()) {
			return new ResponseEntity<List<ParentDomain>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ParentDomain>>(parentDomainList, HttpStatus.OK);
	}

	// -------------------display -----------------------

	@RequestMapping(value = "/annotations/parentDomain/{parentDomainId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ParentDomain> display(@PathVariable("parentDomainId") int parentDomainId) {
		logger.info("Fetching ParentDomain with parentDomainId " + parentDomainId);
		ParentDomain parentDomain = parentDomainService.display(parentDomainId);
		if (parentDomain == null) {
			logger.info("ParentDomain with parentDomainId " + parentDomainId + " not found");
			return new ResponseEntity<ParentDomain>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ParentDomain>(parentDomain, HttpStatus.OK);
	}

	// -------------------Create a Record -----------------------

	@RequestMapping(value = "/annotations/parentDomain", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody ParentDomain parentDomain, UriComponentsBuilder ucBuilder, HttpServletRequest request) {
		logger.info("Creating ParentDomain " + parentDomain.getParentDomainName());
		parentDomain.setLocId(request.getRemoteAddr());
		parentDomain.setTimeUpdated(new java.util.Date());
		if (parentDomainService.display(parentDomain.getParentDomainId()) != null) {
			logger.info("A ParentDomain with parentDomainId " + parentDomain.getParentDomainId() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		parentDomainService.save(parentDomain);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/annotations/parentDomain").buildAndExpand(parentDomain.getParentDomainId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Record -------------------------------

	@RequestMapping(value = "/annotations/parentDomain/{parentDomainId}", method = RequestMethod.PUT)
	public ResponseEntity<ParentDomain> update(@PathVariable("parentDomainId") int parentDomainId, @RequestBody ParentDomain parentDomain) {
		logger.info("Updating ParentDomain " + parentDomainId);
		ParentDomain oldParentDomain = parentDomainService.display(parentDomainId);
		logger.info("Going to update ParentDomain : " + oldParentDomain);
		if (oldParentDomain == null) {
			logger.info("ParentDomain with parentDomainId " + parentDomainId + " not found");
			return new ResponseEntity<ParentDomain>(HttpStatus.NOT_FOUND);
		}

		parentDomainService.update(parentDomain);
		return new ResponseEntity<ParentDomain>(parentDomain, HttpStatus.OK);
	}

	// ------------------- Delete a Record ----------------

	@RequestMapping(value = "/annotations/parentDomain/{parentDomainId}", method = RequestMethod.DELETE)
	public ResponseEntity<ParentDomain> delete(@PathVariable("parentDomainId") int parentDomainId) {
		logger.info("Fetching & Deleting ParentDomain with parentDomainId " + parentDomainId);
		ParentDomain parentDomain = parentDomainService.display(parentDomainId);
		if (parentDomain == null) {
			logger.info("Unable to delete. ParentDomain with parentDomainId " + parentDomainId + " not found");
			return new ResponseEntity<ParentDomain>(HttpStatus.NOT_FOUND);
		}
		parentDomainService.delete(parentDomainId);
		return new ResponseEntity<ParentDomain>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All ---------------

	@RequestMapping(value = "/annotations/parentDomain", method = RequestMethod.DELETE)
	public ResponseEntity<ParentDomain> deleteAll() {
		logger.info("Deleting All ParentDomains");
		parentDomainService.delete(1);
		return new ResponseEntity<ParentDomain>(HttpStatus.NO_CONTENT);
	}

}