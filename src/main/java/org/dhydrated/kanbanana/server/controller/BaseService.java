package org.dhydrated.kanbanana.server.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.dhydrated.kanbanana.server.repository.BaseRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class BaseService<E> {

	private Logger log = Logger.getLogger(BaseService.class.getName());

	public List<E> list(String parentId) {
		
		log.log(Level.INFO, "get");
	
		return getRepository().list(parentId);
	}
	
	public E get(@PathVariable("id") String id) throws Exception{
		
		log.log(Level.INFO, "get");
		
		return getRepository().get(id);
	}

	public E save(@RequestBody E entity) {
	
		log.log(Level.INFO, "save");
	
		log.log(Level.INFO, "Entity: " + entity);
		
		getRepository().save(entity);
		
		return entity;
	}
	
	public Boolean delete(@PathVariable("id") String id) throws Exception{
		
		log.log(Level.INFO, "delete");
		
		try {
			getRepository().delete(id);
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	public abstract BaseRepository<E> getRepository();

	public abstract void setRepository(BaseRepository<E> repository);

}
