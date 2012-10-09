package org.dhydrated.kanbanana.server.controller;


import java.util.List;

import org.dhydrated.kanbanana.server.model.Project;
import org.dhydrated.kanbanana.server.repository.BaseRepository;
import org.dhydrated.kanbanana.server.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ProjectService extends BaseService<Project> {
	
	@Autowired
	private ProjectRepository repository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/project", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<Project> list() {
		
		return super.list(null);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/project/{id}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Project get(@PathVariable("id") String id) throws Exception{
		
		return super.get(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/project", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Project save(@RequestBody Project project) {
	
		return super.save(project);
	}

	@Override
	public ProjectRepository getRepository() {
		return repository;
	}

	@Override
	public void setRepository(BaseRepository<Project> repository) {
		this.repository = (ProjectRepository)repository;
	}
}
