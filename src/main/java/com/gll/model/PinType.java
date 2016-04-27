package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PinType {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pinTypeId;
	/* It could be:
	 * 1. Visual Designer
	 * 2. Interaction Designer
	 * 3. Prototyper
	 * 4. User Tester
	 * 5. Information Architect
	 * 6. User Researcher
	 * 7. Content Writer etc
	 * 
	 * */
	private String pinTypeDescription;
	private String pinTypeColor;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;
	
	public PinType() {
		// TODO Auto-generated constructor stub
	}

	
}
