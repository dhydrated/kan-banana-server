package org.dhydrated.kanbanana.server.model;

import javax.persistence.Entity;

import org.springframework.stereotype.Repository;

@SuppressWarnings("serial")
@Repository
@Entity
public class Project extends BaseModel {
	
    private String projectName;
    
    private String description;
    
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
}
