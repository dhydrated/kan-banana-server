package org.dhydrated.kanbanana.server.model;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class ProjectMember extends BaseModel {

	private String projectId;
	
	private String email;
	
	private ProjectRole role;

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ProjectRole getRole() {
		return role;
	}

	public void setRole(ProjectRole role) {
		this.role = role;
	}
	
	
}
