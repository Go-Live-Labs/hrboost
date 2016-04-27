package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Payment {

	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int paymentId;
	private Date paymentDate;
	private double paymentAmount;
	private String paymentCurrency;
	private String paymentGateway; //stripe, paypal
	private String paymentStatus;
	private String paymentReferenceToken;
	private int premiumPlanId;
	private int userId;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int updatedBy;

	public Payment() {
		// TODO Auto-generated constructor stub
	}

}