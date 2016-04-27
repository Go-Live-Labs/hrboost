package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserProfile {
	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	private String userName;
	private String userFirstName;
	private String userLastName;
	private StringBuffer userPicURL;
	private String userEmail;
	private String userEmployer;
	private String userDesignation;
	private String userCity;
	private String userState;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy; 

	public UserProfile() {
		// TODO Auto-generated constructor stub
	}

	
}