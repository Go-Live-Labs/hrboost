package com.gll.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Hashtag {
	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int annotationHashtagId;
	private String annotationHashtagDescription;
	private char useStatus;
	private String programId;
	private String locId;
	private Date timeUpdated;
	private int updatedBy;

	public Hashtag() {

	}

	public Hashtag(int annotationHashtagId, String annotationHashtagDescription, char useStatus, String programId,
			String locId, Date timeUpdated, int updatedBy) {
		super();
		this.annotationHashtagId = annotationHashtagId;
		this.annotationHashtagDescription = annotationHashtagDescription;
		this.useStatus = useStatus;
		this.programId = programId;
		this.locId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}

	public int getAnnotationHashtagId() {
		return annotationHashtagId;
	}

	public void setAnnotationHashtagId(int annotationHashtagId) {
		this.annotationHashtagId = annotationHashtagId;
	}

	public String getAnnotationHashtagDescription() {
		return annotationHashtagDescription;
	}

	public void setAnnotationHashtagDescription(String annotationHashtagDescription) {
		this.annotationHashtagDescription = annotationHashtagDescription;
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
		return "Hashtag [annotationHashtagId=" + annotationHashtagId + ", annotationHashtagDescription="
				+ annotationHashtagDescription + ", useStatus=" + useStatus + ", programId=" + programId + ", locId="
				+ locId + ", timeUpdated=" + timeUpdated + ", updatedBy=" + updatedBy + "]";
	}

}