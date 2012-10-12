package org.dhydrated.kanbanana.server.model;

import java.util.Date;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class History extends BaseModel {

	private String text;
	
	private String storyId;
	
	private Date date;
}
