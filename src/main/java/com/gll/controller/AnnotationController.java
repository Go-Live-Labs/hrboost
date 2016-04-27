/*package com.gll.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.metadata.CollectionMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gll.model.AnnotationModel;
import com.gll.model.Comment;
import com.gll.service.AnnotationService;

@RestController
public class AnnotationController {

	private static final Logger logger = Logger.getLogger(AnnotationController.class);

	@Autowired
	AnnotationService annotationService;

	// -------------------Retrieve All Annotations-----------------------------------
	@RequestMapping(value = "/annotations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AnnotationModel>> displayAll() {
		List<AnnotationModel> annotationList = annotationService.displayAll();
		if (annotationList.isEmpty()) {
			return new ResponseEntity<List<AnnotationModel>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AnnotationModel>>(annotationList, HttpStatus.OK);
	}

	// -------------------Retrieve Annotation by annotationId -----------------------

	@RequestMapping(value = "/annotations/{annotationId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AnnotationModel>> getAnnotationsByannotationId(@RequestParam("annotationId") int annotationId) {
		List<AnnotationModel> annotationList = annotationService.getAnnotationsbyannotationId(annotationId);
		if (annotationList.isEmpty()) {
			return new ResponseEntity<List<AnnotationModel>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AnnotationModel>>(annotationList, HttpStatus.OK);
	}

	// -------------------Retrieve Annotation by User Name -----------------------

	@RequestMapping(value = "/annotations/{userName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AnnotationModel>> getAnnotationsByUserName(@PathVariable("userName") String userName) {
		List<AnnotationModel> annotationList = annotationService.getAnnotationsByUserName(userName);
		if (annotationList.isEmpty()) {
			return new ResponseEntity<List<AnnotationModel>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AnnotationModel>>(annotationList, HttpStatus.OK);
	}


	// -------------------Retrieve All Annotations by Domain Name -----------------------

		@RequestMapping(value = "/annotations/domainName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<AnnotationModel>> getAnnotationsByDomainName(@RequestParam(value="domainName", required=true) String domainName) {
			logger.debug("********************** :Controller->getAnnotationsByDomainName()->domainName = " + domainName);
			List<AnnotationModel> annotationList = annotationService.getAnnotationsByDomainName(domainName);
			if (annotationList.isEmpty()) {
				return new ResponseEntity<List<AnnotationModel>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<AnnotationModel>>(annotationList, HttpStatus.OK);
		}

		// -------------------Retrieve All Annotations by Root Domain Name -----------------------

		@RequestMapping(value = "/annotations/rootDomain", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<AnnotationModel>> getAnnotationsByRootDomain(@RequestParam(value="rootDomain", required=true) String rootDomain) {
			List<AnnotationModel> annotationList = annotationService.getAnnotationsByRootDomain(rootDomain);
			if (annotationList.isEmpty()) {
				return new ResponseEntity<List<AnnotationModel>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<AnnotationModel>>(annotationList, HttpStatus.OK);
		}

		// -------------------Create Annotation -----------------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations", method = RequestMethod.POST)
	public ResponseEntity<Void> save(@PathVariable("userId") int userId, @PathVariable("websiteId") int websiteId, @RequestBody AnnotationModel annotationModel, UriComponentsBuilder ucBuilder) {
	
		if (annotationService.display(annotationModel.getannotationId()) != null) {
			logger.info("A AnnotationModel with name " + annotationModel.getText() + " already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}

		annotationService.save(annotationModel);

		HttpHeaders headers = new HttpHeaders();
	
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("userId", annotationModel.getUserId());
		map.put("websiteId", annotationModel.getWebsiteId());
		map.put("annotationId", annotationModel.getAnnotationId());

		headers.setLocation(ucBuilder.path("/users/{userId}/websites/{websiteId}/annotations").buildAndExpand(map).toUri());
		
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	// -------------------Retrieve All Annotation by userId and websiteId -----------------------------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AnnotationModel>> displayAll(@PathVariable("userId") int userId, @PathVariable("websiteId") int websiteId) {
		List<AnnotationModel> annotationList = annotationService.displayAll();
		if (annotationList.isEmpty()) {
			return new ResponseEntity<List<AnnotationModel>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AnnotationModel>>(annotationList, HttpStatus.OK);
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	// -------------------Retrieve Comments by annotationId -----------------------------------
		@RequestMapping(value = "/annotations/{annotationId}/comments", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<List<AnnotationModel>> getAllComments(@PathVariable("annotationId") int annotationId) {
			List<AnnotationModel> annotationList = annotationService.getAllComments(annotationId);
			if (annotationList.isEmpty()) {
				return new ResponseEntity<List<AnnotationModel>>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<List<AnnotationModel>>(annotationList, HttpStatus.OK);
		}
	
		// -------------------Store Comment by annotationId -----------------------

		@RequestMapping(value = "/annotations/{annotationId}/comments", method = RequestMethod.POST)
		public ResponseEntity<Void> saveComment(@PathVariable("annotationId") int annotationId, @RequestBody Comment comment, UriComponentsBuilder ucBuilder) {
		
			if (annotationService.display(annotationId) == null) {
				logger.info("annotationId does not exist! Can not give comment!");
				return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
			}
			
			annotationService.saveComment(comment);

			HttpHeaders headers = new HttpHeaders();
			Map<String,Integer> map = new HashMap<String,Integer>();
			map.put("annotationId", annotationId);
		
			headers.setLocation(ucBuilder.path("/annotations/{annotationId}/comments").buildAndExpand(map).toUri());
			
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}

		


	// -------------------Retrieve Single Record -----------------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations/{annotationId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AnnotationModel> getSinglRecord(@PathVariable("userId") int userId, @PathVariable("websiteId") int websiteId, @PathVariable("annotationId") int annotationId) {
		logger.info("********************: Fetching AnnotationModel with annotationId " + annotationId);
		AnnotationModel annotationModel = annotationService.display(annotationId);
		if (annotationModel == null) {
			logger.info("AnnotationModel with annotationId " + annotationId + " not found");
			return new ResponseEntity<AnnotationModel>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AnnotationModel>(annotationModel, HttpStatus.OK);
	}

	// ------------------- Update a Record -------------------------------
	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations/{annotationId}", method = RequestMethod.PUT)
	public ResponseEntity<AnnotationModel> update(@PathVariable("userId") int userId,	@PathVariable("websiteId") int websiteId, @PathVariable("annotationId") int annotationId, @RequestBody AnnotationModel annotationModel) {
		logger.info("Updating AnnotationModel " + annotationId);
		AnnotationModel currentAnnotationModel = annotationService.display(annotationId);
		logger.info("Going to update AnnotationModel : " + currentAnnotationModel);
		if (currentAnnotationModel == null) {
			logger.info("AnnotationModel with annotationId " + annotationId + " not found");
			return new ResponseEntity<AnnotationModel>(HttpStatus.NOT_FOUND);
		}

		annotationService.update(annotationModel);
		return new ResponseEntity<AnnotationModel>(annotationModel, HttpStatus.OK);
	}

	// ------------------- Delete a Record ----------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations/{annotationId}", method = RequestMethod.DELETE)
	public ResponseEntity<AnnotationModel> delete(@PathVariable("userId") int userId, @PathVariable("websiteId") int websiteId, @PathVariable("annotationId") int annotationId) {
		logger.info("Fetching & Deleting AnnotationModel with annotationId " + annotationId);
		AnnotationModel annotationModel = annotationService.display(annotationId);
		if (annotationModel == null) {
			logger.info("Unable to delete. AnnotationModel with annotationId " + annotationId + " not found");
			return new ResponseEntity<AnnotationModel>(HttpStatus.NOT_FOUND);
		}
		annotationService.delete(annotationId);
		return new ResponseEntity<AnnotationModel>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All ---------------

	@RequestMapping(value = "/users/{userId}/websites/{websiteId}/annotations", method = RequestMethod.DELETE)
	public ResponseEntity<AnnotationModel> deleteAll() {
		logger.info("Deleting All AnnotationModels");
		annotationService.delete(1);
		return new ResponseEntity<AnnotationModel>(HttpStatus.NO_CONTENT);
	}

}*/