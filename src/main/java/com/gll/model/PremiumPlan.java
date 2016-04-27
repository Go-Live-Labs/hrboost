package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PremiumPlan {
	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int premiumPlanId;
	private String premiumPlanDescription;
	private double premiumPlanCost;
	private String premiumPlanCurrency;
	private String planConstraints;
	private int planEffectiveDays; // 30[monthly], 365 [yearly]
	private boolean planAutoRenewal;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	//@OneToOne
	private int updatedBy;
	
	public PremiumPlan() {
		// TODO Auto-generated constructor stub
	}
}