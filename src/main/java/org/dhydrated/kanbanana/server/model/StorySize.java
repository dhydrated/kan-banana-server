package org.dhydrated.kanbanana.server.model;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class StorySize extends BaseModel {

	private String name;
	
	private Integer value;
	
	private String projectId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	
}
