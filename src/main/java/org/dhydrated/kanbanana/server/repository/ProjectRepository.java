package org.dhydrated.kanbanana.server.repository;

import org.dhydrated.kanbanana.server.model.Project;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectRepository extends BaseRepository<Project> {

	@Override
	public String getAllQuery() {
		
		return "SELECT * FROM Project";
	}
}
