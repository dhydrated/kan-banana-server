
package org.dhydrated.kanbanana.server.model;

@SuppressWarnings("serial")
public class StoryType extends BaseModel {

	private String name;
	
	private String color;
	
	private String projectId;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	
	
}
