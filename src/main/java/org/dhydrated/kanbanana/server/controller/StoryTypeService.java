package org.dhydrated.kanbanana.server.controller;


import java.util.List;

import org.dhydrated.kanbanana.server.model.StoryType;
import org.dhydrated.kanbanana.server.repository.BaseRepository;
import org.dhydrated.kanbanana.server.repository.StoryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class StoryTypeService extends BaseService<StoryType> {
	

	@Autowired
	private StoryTypeRepository repository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/story_type", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<StoryType> list() {
		
		return super.list(null);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/story_type/{id}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public StoryType get(@PathVariable("id") String id) throws Exception{
		
		return super.get(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/story_type", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public StoryType save(@RequestBody StoryType storyType) {
	
		return super.save(storyType);
	}
	

	@Override
	public StoryTypeRepository getRepository() {
		return repository;
	}

	@Override
	public void setRepository(BaseRepository<StoryType> repository) {
		this.repository = (StoryTypeRepository)repository;
	}
}
