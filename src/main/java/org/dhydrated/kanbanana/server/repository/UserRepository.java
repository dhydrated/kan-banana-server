package org.dhydrated.kanbanana.server.repository;

import org.dhydrated.kanbanana.server.model.User;

public interface UserRepository extends BaseRepository<User>{
	
	public User getByUsername(String username);

}
