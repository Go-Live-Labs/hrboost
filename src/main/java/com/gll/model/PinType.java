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
	private String locId;
	private Date timeUpdated;
	private int updatedBy;
	
	public PinType() {
	}

	public PinType(int pinTypeId, String pinTypeDescription, String pinTypeColor, char useStatus, String programId,
			String locId, Date timeUpdated, int updatedBy) {
		super();
		this.pinTypeId = pinTypeId;
		this.pinTypeDescription = pinTypeDescription;
		this.pinTypeColor = pinTypeColor;
		this.useStatus = useStatus;
		this.programId = programId;
		this.locId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}

	public int getPinTypeId() {
		return pinTypeId;
	}

	public void setPinTypeId(int pinTypeId) {
		this.pinTypeId = pinTypeId;
	}

	public String getPinTypeDescription() {
		return pinTypeDescription;
	}

	public void setPinTypeDescription(String pinTypeDescription) {
		this.pinTypeDescription = pinTypeDescription;
	}

	public String getPinTypeColor() {
		return pinTypeColor;
	}

	public void setPinTypeColor(String pinTypeColor) {
		this.pinTypeColor = pinTypeColor;
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
		return "PinType [pinTypeId=" + pinTypeId + ", pinTypeDescription=" + pinTypeDescription + ", pinTypeColor="
				+ pinTypeColor + ", useStatus=" + useStatus + ", programId=" + programId + ", locId=" + locId
				+ ", timeUpdated=" + timeUpdated + ", updatedBy=" + updatedBy + "]";
	}

	
	
}
