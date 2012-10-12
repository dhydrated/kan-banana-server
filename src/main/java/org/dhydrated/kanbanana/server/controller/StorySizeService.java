package org.dhydrated.kanbanana.server.controller;


import java.util.List;

import org.dhydrated.kanbanana.server.model.StorySize;
import org.dhydrated.kanbanana.server.repository.BaseRepository;
import org.dhydrated.kanbanana.server.repository.StorySizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class StorySizeService extends BaseService<StorySize> {
	

	@Autowired
	private StorySizeRepository repository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/project/{projectId}/story_size", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<StorySize> list(@PathVariable("projectId") String projectId) {
		
		return super.list(projectId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/project/{projectId}/story_size/{id}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public StorySize get(@PathVariable("projectId") String projectId, @PathVariable("id") String id) throws Exception{
		
		return super.get(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/project/{projectId}/story_size", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public StorySize save(@PathVariable("projectId") String projectId, @RequestBody StorySize StorySize) {
	
		return super.save(StorySize);
	}

	@Override
	public StorySizeRepository getRepository() {
		return repository;
	}

	@Override
	public void setRepository(BaseRepository<StorySize> repository) {
		this.repository = (StorySizeRepository)repository;
	}
}
