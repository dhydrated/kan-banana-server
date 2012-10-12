package org.dhydrated.kanbanana.server.repository;

import org.dhydrated.kanbanana.server.model.StoryType;
import org.springframework.stereotype.Repository;

@Repository
public class StoryTypeRepositoryJpaImpl extends BaseRepositoryJpaImpl<StoryType> implements StoryTypeRepository {

	@Override
	public String getAllQuery() {
		
		return "SELECT e FROM StoryType e WHERE e.project.id=:parentId";
	}

	@Override
	protected Class<StoryType> getEntityClass() {
		return StoryType.class;
	}

	@Override
	public StoryType createEntity() {
		return new StoryType();
	}
}
