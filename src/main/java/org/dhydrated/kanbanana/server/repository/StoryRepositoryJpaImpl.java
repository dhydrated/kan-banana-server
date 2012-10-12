package org.dhydrated.kanbanana.server.repository;

import org.dhydrated.kanbanana.server.model.Story;
import org.springframework.stereotype.Repository;

@Repository
public class StoryRepositoryJpaImpl extends BaseRepositoryJpaImpl<Story> implements StoryRepository {

	@Override
	public String getAllQuery() {
		
		return "SELECT e FROM Story e WHERE e.projectId=:parentId";
	}

	@Override
	protected Class<Story> getEntityClass() {
		return Story.class;
	}

	@Override
	public Story createEntity() {
		return new Story();
	}
}
