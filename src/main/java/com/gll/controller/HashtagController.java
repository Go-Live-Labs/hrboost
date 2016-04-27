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

import com.gll.model.Hashtag;
import com.gll.service.HashtagService;

@RestController
public class HashtagController {

	private static final Logger logger = Logger.getLogger(HashtagController.class);

	@Autowired
	HashtagService hashtagService;

	// -------------------display All -----------------------------------

	@RequestMapping(value = "/annotations/hashtag", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Hashtag>> getAll() {
		List<Hashtag> hashtagList = hashtagService.getAll();
		if (hashtagList.isEmpty()) {
			return new ResponseEntity<List<Hashtag>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Hashtag>>(hashtagList, HttpStatus.OK);
	}

	// -------------------display -----------------------

	@RequestMapping(value = "/annotations/hashtag/{hashtagId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Hashtag> display(@PathVariable("hashtagId") int hashtagId) {
		logger.info("Fetching Hashtag with hashtagId " + hashtagId);
		Hashtag hashtag = hashtagService.get(hashtagId);
		if (hashtag == null) {
			logger.info("Hashtag with hashtagId " + hashtagId + " not found");
			return new ResponseEntity<Hashtag>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Hashtag>(hashtag, HttpStatus.OK);
	}

	// -------------------Create a Record -----------------------

	@RequestMapping(value = "/annotations/hashtag", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Hashtag hashtag, UriComponentsBuilder ucBuilder, HttpServletRequest request) {
		logger.info("Creating Hashtag " + hashtag.getAnnotationHashtagId());
		hashtag.setLocId(request.getRemoteAddr());
		hashtag.setTimeUpdated(new java.util.Date());
		if (hashtagService.get(hashtag.getAnnotationHashtagId()) != null) {
			logger.info("A Hashtag with hashtagId " + hashtag.getAnnotationHashtagId() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		hashtagService.post(hashtag);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/annotations/hashtag").buildAndExpand(hashtag.getAnnotationHashtagId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Record -------------------------------

	@RequestMapping(value = "/annotations/hashtag/{hashtagId}", method = RequestMethod.PUT)
	public ResponseEntity<Hashtag> update(@PathVariable("hashtagId") int hashtagId, @RequestBody Hashtag hashtag) {
		logger.info("Updating Hashtag " + hashtagId);
		Hashtag oldHashtag = hashtagService.get(hashtagId);
		logger.info("Going to update Hashtag : " + oldHashtag);
		if (oldHashtag == null) {
			logger.info("Hashtag with HashtagId " + hashtagId + " not found");
			return new ResponseEntity<Hashtag>(HttpStatus.NOT_FOUND);
		}

		hashtagService.put(hashtag);
		return new ResponseEntity<Hashtag>(hashtag, HttpStatus.OK);
	}

	// ------------------- Delete a Record ----------------

	@RequestMapping(value = "/annotations/hashtag/{hashtagId}", method = RequestMethod.DELETE)
	public ResponseEntity<Hashtag> delete(@PathVariable("hashtagId") int hashtagId) {
		logger.info("Fetching & Deleting Hashtag with HashtagId " + hashtagId);
		Hashtag hashtag = hashtagService.get(hashtagId);
		if (hashtag == null) {
			logger.info("Unable to delete. Hashtag with HashtagId " + hashtagId + " not found");
			return new ResponseEntity<Hashtag>(HttpStatus.NOT_FOUND);
		}
		hashtagService.delete(hashtagId);
		return new ResponseEntity<Hashtag>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All ---------------

	@RequestMapping(value = "/annotations/hashtag", method = RequestMethod.DELETE)
	public ResponseEntity<Hashtag> deleteAll() {
		logger.info("Deleting All Hashtags");
		hashtagService.delete(1);
		return new ResponseEntity<Hashtag>(HttpStatus.NO_CONTENT);
	}

}