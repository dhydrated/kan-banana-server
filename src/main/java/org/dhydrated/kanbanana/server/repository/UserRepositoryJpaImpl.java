package org.dhydrated.kanbanana.server.repository;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.Query;

import org.dhydrated.kanbanana.server.model.ProjectMember;
import org.dhydrated.kanbanana.server.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryJpaImpl extends BaseRepositoryJpaImpl<User> implements UserRepository {

	private Logger log = Logger.getLogger(UserRepositoryJpaImpl.class.getName());
	
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
	public User getByUsername(String email) {
		
		User entity = new User();
		
		log.log(Level.INFO, "email: " + email);
	
		final Query query = getEntityManager()
				.createQuery("SELECT e FROM User e WHERE e.email=:email");
		
		query.setParameter("email", email);

		try {
		entity = (User) query.getSingleResult();
		}
		catch(Exception e){
			log.log(Level.WARNING, e.getMessage());
		}
		
		return entity;
	}
}
