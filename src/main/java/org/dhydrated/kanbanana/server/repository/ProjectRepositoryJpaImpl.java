package org.dhydrated.kanbanana.server.repository;

import org.dhydrated.kanbanana.server.model.Project;
import org.springframework.stereotype.Repository;

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
}
