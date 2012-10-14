package org.dhydrated.kanbanana.server.repository;

import org.dhydrated.kanbanana.server.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryJpaImpl extends BaseRepositoryJpaImpl<User> implements UserRepository {

	@Override
	public String getAllQuery() {
		
		return "SELECT e FROM User e";
	}

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

	@Override
	public User createEntity() {
		return new User();
	}
}
