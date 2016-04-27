package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Annotation {

	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int annotationId;
	private String annotationTitle;
	private String annotationText;
	private int emojiId;
	private int pinTypeId;

	private int annotationContentTypeId;
	private int annotationTypeId;
	
	private int parentDomainId;

	private long specificURL;
	private String pinXCoordinate;
	private String pinYCoordinate;
	private String annotationAudioURL;
	private String annotationAttachmentURL;

	private StringBuffer annotationScreenshot;
	private int annotationScreenshotHeight;
	private int annotationScreenshotWidth;
	private String annotationScreenshotPinXCoordinate;
	private String annotationScreenshotPinYCoordinate;

	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;
	
	
	public Annotation() {
		
	}
}