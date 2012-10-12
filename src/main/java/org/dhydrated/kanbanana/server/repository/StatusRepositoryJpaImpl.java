package org.dhydrated.kanbanana.server.repository;

import org.dhydrated.kanbanana.server.model.Status;
import org.springframework.stereotype.Repository;

@Repository
public class StatusRepositoryJpaImpl extends BaseRepositoryJpaImpl<Status> implements StatusRepository {

	@Override
	public String getAllQuery() {
		
		return "SELECT e FROM Status e WHERE e.projectId=:parentId";
	}

	@Override
	protected Class<Status> getEntityClass() {
		return Status.class;
	}

	@Override
	public Status createEntity() {
		return new Status();
	}
}
