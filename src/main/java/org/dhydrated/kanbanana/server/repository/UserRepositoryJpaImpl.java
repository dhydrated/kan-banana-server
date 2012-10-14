package org.dhydrated.kanbanana.server.repository;

import javax.persistence.Query;

import org.dhydrated.kanbanana.server.model.ProjectMember;
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

	@Override
	public User getByUsername(String username) {
		
		User entity = new User();
	
		final Query query = getEntityManager()
				.createQuery("SELECT e FROM ProjectMember e WHERE e.username=:username");
		
		query.setParameter("username", username);
	
		entity = (User) query.getSingleResult();
	
		return entity;
	}
}
