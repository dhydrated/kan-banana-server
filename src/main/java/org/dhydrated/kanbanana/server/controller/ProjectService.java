package org.dhydrated.kanbanana.server.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.dhydrated.kanbanana.server.model.Project;
import org.dhydrated.kanbanana.server.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jappstart.exception.DuplicateUserException;


@Controller
public class ProjectService {
	
	private Logger log = Logger.getLogger(ProjectService.class.getName());
	
	@Autowired
	private ProjectRepository repository;
	
/*
    @PersistenceContext
    private transient EntityManager entityManager;*/
    
//    private MemcacheService memcacheService;
    
//    private DatastoreService datastoreService;
    
	@RequestMapping(method=RequestMethod.GET, value="/project", produces="application/json")
	public @ResponseBody List<Project> get() {
		
		log.log(Level.INFO, "get");

		return getRepository().list();
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/project", consumes="application/json", produces="application/json")
	public @ResponseBody Project save(@RequestBody Project project) {

		log.log(Level.INFO, "save");

		log.log(Level.INFO, "Project: " + project);
		
		getRepository().save(project);
		
		return project;
	}

	

	public ProjectRepository getRepository() {
		return repository;
	}

	public void setRepository(ProjectRepository repository) {
		this.repository = repository;
	}
}
