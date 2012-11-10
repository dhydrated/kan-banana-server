package org.dhydrated.kanbanana.server.controller;


import java.util.List;

import org.dhydrated.kanbanana.server.model.Project;
import org.dhydrated.kanbanana.server.model.ProjectMember;
import org.dhydrated.kanbanana.server.repository.BaseRepository;
import org.dhydrated.kanbanana.server.repository.ProjectMemberRepository;
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

	@Autowired
	private ProjectMemberRepository projectMemberRepository;
	
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

	@RequestMapping(
			method = RequestMethod.PUT, 
			value = "/project/{id}", 
			consumes = "application/json", 
			produces = "application/json")
	@ResponseBody
	public Project update(@PathVariable("id") String id, @RequestBody Project project) {
	
		return super.save(project);
	}
	
	@RequestMapping(
			method = RequestMethod.POST, 
			value = "/project", 
			consumes = "application/json", 
			produces = "application/json")
	@ResponseBody
	public Project create(@RequestBody Project project) {
	
		return super.save(project);
	}
	
	@RequestMapping(
			method = RequestMethod.DELETE, 
			value = "/project/{id}", 
			consumes = "application/json", 
			produces = "application/json")
	@ResponseBody
	public Boolean delete(@PathVariable("id") String id) throws Exception {
		
		return super.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/user/{userId}/project/", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<Project> userProjects(@PathVariable("userId") String userId) throws Exception {
		
		return this.getRepository().list(this.getProjectMemberRepository().getByUserId(userId));
	}

	@Override
	public ProjectRepository getRepository() {
		return repository;
	}

	@Override
	public void setRepository(BaseRepository<Project> repository) {
		this.repository = (ProjectRepository)repository;
	}

	public ProjectMemberRepository getProjectMemberRepository() {
		return projectMemberRepository;
	}

	public void setProjectMemberRepository(BaseRepository<ProjectMember> repository) {
		this.projectMemberRepository = (ProjectMemberRepository)repository;
	}
}
