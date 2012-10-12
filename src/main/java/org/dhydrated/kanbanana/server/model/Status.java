
package org.dhydrated.kanbanana.server.model;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Status extends BaseModel {

	private String name;
	
	private Integer position;
	
	private String projectId;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	
}
