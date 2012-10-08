package org.dhydrated.kanbanana.server.repository;

import org.dhydrated.kanbanana.server.model.Project;
import org.springframework.stereotype.Repository;

@Repository
public class StoryTypeRepository extends BaseRepository<Project> {

	@Override
	public String getAllQuery() {
		
		return "SELECT * FROM StoryType st WHERE st.project.id=:parentId";
	}
}
