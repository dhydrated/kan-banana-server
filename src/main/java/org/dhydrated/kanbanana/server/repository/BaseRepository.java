package org.dhydrated.kanbanana.server.repository;

import java.util.List;

public interface BaseRepository<E> {

	public List<E> list(String parentId);

	public E get(String id) throws Exception;
	
	public E save(E entity);
	
	public void delete(String id) throws Exception;

}
