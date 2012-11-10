package org.dhydrated.kanbanana.server.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.dhydrated.kanbanana.server.model.Project;
import org.dhydrated.kanbanana.server.model.ProjectMember;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProjectRepositoryJpaImpl extends BaseRepositoryJpaImpl<Project> implements ProjectRepository {

	@Override
	public String getAllQuery() {
		
		return "SELECT e FROM Project e";
	}

	@Override
	protected Class<Project> getEntityClass() {
		return Project.class;
	}

	@Override
	public Project createEntity() {
		return new Project();
	}

	@Override
	public List<Project> list(List<ProjectMember> projectMembers) throws Exception{
	
		List<Project> projects = new ArrayList<Project>();
		
		if(projectMembers != null){
			
			for(ProjectMember projectMember : projectMembers){
				
				projects.add(this.get(projectMember.getProjectId()));
			}
		}
		
		return null;
	}
	
}
