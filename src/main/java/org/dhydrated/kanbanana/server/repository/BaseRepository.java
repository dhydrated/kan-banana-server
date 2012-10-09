package org.dhydrated.kanbanana.server.repository;

import java.util.List;

public interface BaseRepository<E> {

	public abstract List<E> list(String parentId);

	public abstract E get(String Id) throws Exception;
	
	public abstract E save(E entity);

}
