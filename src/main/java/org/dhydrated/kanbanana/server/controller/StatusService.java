package org.dhydrated.kanbanana.server.controller;


import java.util.List;

import org.dhydrated.kanbanana.server.model.Status;
import org.dhydrated.kanbanana.server.repository.BaseRepository;
import org.dhydrated.kanbanana.server.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class StatusService extends BaseService<Status> {
	

	@Autowired
	private StatusRepository repository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/project/{projectId}/status", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<Status> list(@PathVariable("projectId") String projectId) {
		
		return super.list(projectId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/project/{projectId}/status/{id}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Status get(@PathVariable("projectId") String projectId, @PathVariable("id") String id) throws Exception{
		
		return super.get(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/project/{projectId}/status", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Status update(@PathVariable("projectId") String projectId, @RequestBody Status Status) {
	
		return super.save(Status);
	}
	
	@RequestMapping(
			method = RequestMethod.POST, 
			value = "/project/{projectId}/status", 
			consumes = "application/json", 
			produces = "application/json")
	@ResponseBody
	public Status create(@PathVariable("projectId") String storyId, @RequestBody Status status) {
	
		return super.save(status);
	}
	
	@RequestMapping(
			method = RequestMethod.DELETE, 
			value = "/project/{projectId}/status/{id}", 
			consumes = "application/json", 
			produces = "application/json")
	@ResponseBody
	public Boolean delete(@PathVariable("projectId") String storyId, @PathVariable("id") String id) throws Exception {
		
		return super.delete(id);
	}
	

	@Override
	public StatusRepository getRepository() {
		return repository;
	}

	@Override
	public void setRepository(BaseRepository<Status> repository) {
		this.repository = (StatusRepository)repository;
	}
}
