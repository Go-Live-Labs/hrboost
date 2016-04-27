package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AnnotationType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int annotationTypeId;
	
	private String annotationTypeDescription;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;
	
	
	
	public AnnotationType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}