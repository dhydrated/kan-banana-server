package org.dhydrated.kanbanana.server.repository;

import org.dhydrated.kanbanana.server.model.StorySize;
import org.springframework.stereotype.Repository;

@Repository
public class StorySizeRepositoryJpaImpl extends BaseRepositoryJpaImpl<StorySize> implements StorySizeRepository {

	@Override
	public String getAllQuery() {
		
		return "SELECT e FROM StorySize e WHERE e.project.id=:parentId";
	}

	@Override
	protected Class<StorySize> getEntityClass() {
		return StorySize.class;
	}

	@Override
	public StorySize createEntity() {
		return new StorySize();
	}
}
