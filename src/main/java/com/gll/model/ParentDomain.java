package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ParentDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int parentDomainId;
	
	private int annotationId;
	
	private String parentDomainName;
	private char useStatus;
	private String programId;
	private String locId;
	private Date timeUpdated;
	private int updatedBy;

	public ParentDomain() {
		
	}

	public ParentDomain(int parentDomainId, int annotationId, String parentDomainName, char useStatus, String programId,
			String locId, Date timeUpdated, int updatedBy) {
		super();
		this.parentDomainId = parentDomainId;
		this.annotationId = annotationId;
		this.parentDomainName = parentDomainName;
		this.useStatus = useStatus;
		this.programId = programId;
		this.locId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}

	public int getParentDomainId() {
		return parentDomainId;
	}

	public void setParentDomainId(int parentDomainId) {
		this.parentDomainId = parentDomainId;
	}

	public int getAnnotationId() {
		return annotationId;
	}

	public void setAnnotationId(int annotationId) {
		this.annotationId = annotationId;
	}

	public String getParentDomainName() {
		return parentDomainName;
	}

	public void setParentDomainName(String parentDomainName) {
		this.parentDomainName = parentDomainName;
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
		return locId;
	}

	public void setLocId(String locId) {
		this.locId = locId;
	}

	public Date getTimeUpdated() {
		return timeUpdated;
	}

	public void setTimeUpdated(Date timeUpdated) {
		this.timeUpdated = timeUpdated;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "ParentDomain [parentDomainId=" + parentDomainId + ", annotationId=" + annotationId
				+ ", parentDomainName=" + parentDomainName + ", useStatus=" + useStatus + ", programId=" + programId
				+ ", locId=" + locId + ", timeUpdated=" + timeUpdated + ", updatedBy=" + updatedBy + "]";
	}

	
}