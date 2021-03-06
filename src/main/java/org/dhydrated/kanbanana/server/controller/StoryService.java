package org.dhydrated.kanbanana.server.controller;


import java.util.List;

import org.dhydrated.kanbanana.server.model.Status;
import org.dhydrated.kanbanana.server.model.Story;
import org.dhydrated.kanbanana.server.repository.BaseRepository;
import org.dhydrated.kanbanana.server.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class StoryService extends BaseService<Story> {
	

	@Autowired
	private StoryRepository repository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/project/{projectId}/story", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<Story> list(@PathVariable("projectId") String projectId) {
		
		return super.list(projectId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/project/{projectId}/story/{id}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Story get(@PathVariable("projectId") String projectId, @PathVariable("id") String id) throws Exception{
		
		return super.get(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/project/{projectId}/story", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Story update(@PathVariable("projectId") String projectId, @RequestBody Story story) {
	
		return super.save(story);
	}
	
	@RequestMapping(
			method = RequestMethod.POST, 
			value = "/project/{projectId}/story", 
			consumes = "application/json", 
			produces = "application/json")
	@ResponseBody
	public Story create(@PathVariable("projectId") String storyId, @RequestBody Story story) {
	
		return super.save(story);
	}
	
	@RequestMapping(
			method = RequestMethod.DELETE, 
			value = "/project/{projectId}/story/{id}", 
			consumes = "application/json", 
			produces = "application/json")
	@ResponseBody
	public Boolean delete(@PathVariable("projectId") String storyId, @PathVariable("id") String id) throws Exception {
		
		return super.delete(id);
	}
	

	@Override
	public StoryRepository getRepository() {
		return repository;
	}

	@Override
	public void setRepository(BaseRepository<Story> repository) {
		this.repository = (StoryRepository)repository;
	}
}
