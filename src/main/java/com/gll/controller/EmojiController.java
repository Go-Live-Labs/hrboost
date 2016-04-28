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

import com.gll.model.Emoji;
import com.gll.service.EmojiService;

@RestController
public class EmojiController {

	private static final Logger logger = Logger.getLogger(EmojiController.class);

	@Autowired
	EmojiService emojiService;

	// -------------------display All -----------------------------------

	@RequestMapping(value = "/annotations/emoji", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Emoji>> getAll() {
		List<Emoji> emojiList = emojiService.getAll();
		if (emojiList.isEmpty()) {
			return new ResponseEntity<List<Emoji>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Emoji>>(emojiList, HttpStatus.OK);
	}

	// -------------------display -----------------------

	@RequestMapping(value = "/annotations/emoji/{emojiId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Emoji> display(@PathVariable("emojiId") int emojiId) {
		logger.info("Fetching Emoji with emojiId " + emojiId);
		Emoji emoji = emojiService.get(emojiId);
		if (emoji == null) {
			logger.info("Emoji with emojiId " + emojiId + " not found");
			return new ResponseEntity<Emoji>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Emoji>(emoji, HttpStatus.OK);
	}

	// -------------------Create a Record -----------------------

	@RequestMapping(value = "/annotations/emoji", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@RequestBody Emoji emoji, UriComponentsBuilder ucBuilder, HttpServletRequest request) {
		logger.info("Creating Emoji " + emoji.getEmojiId());
		emoji.setLocId(request.getRemoteAddr());
		emoji.setTimeUpdated(new java.util.Date());
		if (emojiService.get(emoji.getEmojiId()) != null) {
			logger.info("A Emoji with emojiId " + emoji.getEmojiId() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		emojiService.post(emoji);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/annotations/emoji").buildAndExpand(emoji.getEmojiId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Record -------------------------------

	@RequestMapping(value = "/annotations/emoji/{emojiId}", method = RequestMethod.PUT)
	public ResponseEntity<Emoji> update(@PathVariable("emojiId") int emojiId, @RequestBody Emoji emoji) {
		logger.info("Updating Emoji " + emojiId);
		Emoji oldEmoji = emojiService.get(emojiId);
		logger.info("Going to update Emoji : " + oldEmoji);
		if (oldEmoji == null) {
			logger.info("Emoji with EmojiId " + emojiId + " not found");
			return new ResponseEntity<Emoji>(HttpStatus.NOT_FOUND);
		}

		emojiService.put(emoji);
		return new ResponseEntity<Emoji>(emoji, HttpStatus.OK);
	}

	// ------------------- Delete a Record ----------------

	@RequestMapping(value = "/annotations/emoji/{emojiId}", method = RequestMethod.DELETE)
	public ResponseEntity<Emoji> delete(@PathVariable("emojiId") int emojiId) {
		logger.info("Fetching & Deleting Emoji with emojiId " + emojiId);
		Emoji emoji = emojiService.get(emojiId);
		if (emoji == null) {
			logger.info("Unable to delete. Emoji with emojiId " + emojiId + " not found");
			return new ResponseEntity<Emoji>(HttpStatus.NOT_FOUND);
		}
		emojiService.delete(emojiId);
		return new ResponseEntity<Emoji>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All ---------------

	@RequestMapping(value = "/annotations/emoji", method = RequestMethod.DELETE)
	public ResponseEntity<Emoji> deleteAll() {
		logger.info("Deleting All Emojis");
		emojiService.delete(1);
		return new ResponseEntity<Emoji>(HttpStatus.NO_CONTENT);
	}

}