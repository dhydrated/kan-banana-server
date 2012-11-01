package org.dhydrated.kanbanana.server.controller;


import java.util.List;

import org.dhydrated.kanbanana.server.model.History;
import org.dhydrated.kanbanana.server.repository.BaseRepository;
import org.dhydrated.kanbanana.server.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HistoryService extends BaseService<History> {
	

	@Autowired
	private HistoryRepository repository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/story/{storyId}/history", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<History> list(@PathVariable("storyId") String storyId) {
		
		return super.list(storyId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/story/{storyId}/history/{id}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public History get(@PathVariable("storyId") String storyId, @PathVariable("id") String id) throws Exception{
		
		return super.get(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/story/{storyId}/history/{id}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public History update(@PathVariable("storyId") String storyId, @PathVariable("id") String id, @RequestBody History History) {
	
		return super.save(History);
	}
	
	@RequestMapping(
			method = RequestMethod.POST, 
			value = "/story/{storyId}/history", 
			consumes = "application/json", 
			produces = "application/json")
	@ResponseBody
	public History create(@PathVariable("storyId") String storyId, @RequestBody History history) {
	
		return super.save(history);
	}
	
	@RequestMapping(
			method = RequestMethod.DELETE, 
			value = "/story/{storyId}/history/{id}", 
			consumes = "application/json", 
			produces = "application/json")
	@ResponseBody
	public Boolean delete(@PathVariable("storyId") String storyId, @PathVariable("id") String id) throws Exception {
		
		return super.delete(id);
	}

	@Override
	public HistoryRepository getRepository() {
		return repository;
	}

	@Override
	public void setRepository(BaseRepository<History> repository) {
		this.repository = (HistoryRepository)repository;
	}
}
