package org.dhydrated.kanbanana.server.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.dhydrated.kanbanana.server.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

public class BaseService<E> {

	private Logger log = Logger.getLogger(BaseService.class.getName());
	@Autowired
	private BaseRepository<E> repository;

	public List<E> get(String parentId) {
		
		log.log(Level.INFO, "get");
	
		return getRepository().list(parentId);
	}

	public E save(@RequestBody E entity) {
	
		log.log(Level.INFO, "save");
	
		log.log(Level.INFO, "Entity: " + entity);
		
		getRepository().save(entity);
		
		return entity;
	}

	public BaseRepository<E> getRepository() {
		return repository;
	}

	public void setRepository(BaseRepository<E> repository) {
		this.repository = repository;
	}

}
