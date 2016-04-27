package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class UserExpertise {
	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private int pinTypeId;
	private char useStatus;
	private int programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;

	public UserExpertise() {
		// TODO Auto-generated constructor stub
	}

}