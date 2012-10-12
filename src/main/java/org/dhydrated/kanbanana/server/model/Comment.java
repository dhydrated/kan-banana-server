package org.dhydrated.kanbanana.server.model;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Comment extends BaseModel {

	private String text;
	
	private String storyId;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getStoryId() {
		return storyId;
	}

	public void setStoryId(String storyId) {
		this.storyId = storyId;
	}
}
