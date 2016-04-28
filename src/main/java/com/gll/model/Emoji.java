package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Emoji {

	/*
	 * Auto generated Primary.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int emojiId;

	/*
	 * With the help of annotationId property you can know that annotation is
	 * liked!
	 */
//	@ManyToOne
	private int annotationId;
	private String emojiDescription;
	private String emojiCode;
	private String emojiURI;
	private char useStatus;
	private String programId;
	private String locId;
	private Date timeUpdated;
	/*
	 * It will depict who is liking.
	 */
//	@OneToMany
	private int updatedBy;
	
	public Emoji() {
		
	}

	public Emoji(int emojiId, int annotationId, String emojiDescription, String emojiCode, String emojiURI,
			char useStatus, String programId, String locId, Date timeUpdated, int updatedBy) {
		super();
		this.emojiId = emojiId;
		this.annotationId = annotationId;
		this.emojiDescription = emojiDescription;
		this.emojiCode = emojiCode;
		this.emojiURI = emojiURI;
		this.useStatus = useStatus;
		this.programId = programId;
		this.locId = locId;
		this.timeUpdated = timeUpdated;
		this.updatedBy = updatedBy;
	}

	public int getEmojiId() {
		return emojiId;
	}

	public void setEmojiId(int emojiId) {
		this.emojiId = emojiId;
	}

	public int getAnnotationId() {
		return annotationId;
	}

	public void setAnnotationId(int annotationId) {
		this.annotationId = annotationId;
	}

	public String getEmojiDescription() {
		return emojiDescription;
	}

	public void setEmojiDescription(String emojiDescription) {
		this.emojiDescription = emojiDescription;
	}

	public String getEmojiCode() {
		return emojiCode;
	}

	public void setEmojiCode(String emojiCode) {
		this.emojiCode = emojiCode;
	}

	public String getEmojiURI() {
		return emojiURI;
	}

	public void setEmojiURI(String emojiURI) {
		this.emojiURI = emojiURI;
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
		return "Emoji [emojiId=" + emojiId + ", annotationId=" + annotationId + ", emojiDescription=" + emojiDescription
				+ ", emojiCode=" + emojiCode + ", emojiURI=" + emojiURI + ", useStatus=" + useStatus + ", programId="
				+ programId + ", locId=" + locId + ", timeUpdated=" + timeUpdated + ", updatedBy=" + updatedBy + "]";
	}
	
	
	
}
