package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CustomerLicense {
	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerLicenseId;
	private Date dateEffectiveFrom;
	private Date dateEffectiveThru;
	private int customerId;
	private int paymentId;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeupdated;
	private int updatedBy;
	
	public int getCustomerLicenseId() {
		return customerLicenseId;
	}
	public void setCustomerLicenseId(int customerLicenseId) {
		this.customerLicenseId = customerLicenseId;
	}
	public Date getDateEffectiveFrom() {
		return dateEffectiveFrom;
	}
	public void setDateEffectiveFrom(Date dateEffectiveFrom) {
		this.dateEffectiveFrom = dateEffectiveFrom;
	}
	public Date getDateEffectiveThru() {
		return dateEffectiveThru;
	}
	public void setDateEffectiveThru(Date dateEffectiveThru) {
		this.dateEffectiveThru = dateEffectiveThru;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
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
	public Date getTimeupdated() {
		return timeupdated;
	}
	public void setTimeupdated(Date timeupdated) {
		this.timeupdated = timeupdated;
	}
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
}