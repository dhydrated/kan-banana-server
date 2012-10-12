package org.dhydrated.kanbanana.server.repository;

import org.dhydrated.kanbanana.server.model.History;
import org.springframework.stereotype.Repository;

@Repository
public class HistoryRepositoryJpaImpl extends BaseRepositoryJpaImpl<History> implements HistoryRepository {

	@Override
	public String getAllQuery() {
		
		return "SELECT e FROM History e WHERE e.project.id=:parentId";
	}

	@Override
	protected Class<History> getEntityClass() {
		return History.class;
	}

	@Override
	public History createEntity() {
		return new History();
	}
}
