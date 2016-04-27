package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class PlanPermissions {
	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int planPermissionId;
	private String planPermissionCode;
	private int premiumPlanId;
	private String planPermissionDescription;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	private int userId;
	
	public int getPlanPermissionId() {
		return planPermissionId;
	}
	public void setPlanPermissionId(int planPermissionId) {
		this.planPermissionId = planPermissionId;
	}
	public String getPlanPermissionCode() {
		return planPermissionCode;
	}
	public void setPlanPermissionCode(String planPermissionCode) {
		this.planPermissionCode = planPermissionCode;
	}
	public int getPremiumPlanId() {
		return premiumPlanId;
	}
	public void setPremiumPlanId(int premiumPlanId) {
		this.premiumPlanId = premiumPlanId;
	}
	public String getPlanPermissionDescription() {
		return planPermissionDescription;
	}
	public void setPlanPermissionDescription(String planPermissionDescription) {
		this.planPermissionDescription = planPermissionDescription;
	}
	public char getUseStatus() {
		return useStatus;
	}
	public void setUseStatus(char useStatus) {
		this.useStatus = useStatus;
	}
	public String getProgramId() {
		return programId;
	}
	public void setProgramId(String programId) {
		this.programId = programId;
	}
	public String getLocId() {
		return LocId;
	}
	public void setLocId(String locId) {
		LocId = locId;
	}
	public Date getTimeUpdated() {
		return timeUpdated;
	}
	public void setTimeUpdated(Date timeUpdated) {
		this.timeUpdated = timeUpdated;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}