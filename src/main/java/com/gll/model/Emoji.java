package com.gll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author umesh
 *
 */
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
	private String emojiDescription;
	private String emojiCode;
	private String emojiURI;
	private char useStatus;
	private String programId;
	private String LocId;
	private Date timeUpdated;
	/*
	 * It will depict who is liking.
	 */
//	@OneToMany
	private int updatedBy;
	
}
