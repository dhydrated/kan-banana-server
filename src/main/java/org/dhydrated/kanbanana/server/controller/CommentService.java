package org.dhydrated.kanbanana.server.controller;


import java.util.List;

import org.dhydrated.kanbanana.server.model.Comment;
import org.dhydrated.kanbanana.server.repository.BaseRepository;
import org.dhydrated.kanbanana.server.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CommentService extends BaseService<Comment> {
	

	@Autowired
	private CommentRepository repository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/story/{storyId}/comment", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<Comment> list(@PathVariable("storyId") String storyId) {
		
		return super.list(storyId);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/story/{storyId}/comment/{id}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Comment get(@PathVariable("storyId") String storyId, @PathVariable("id") String id) throws Exception{
		
		return super.get(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/story/{storyId}/comment/{id}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Comment save(@PathVariable("storyId") String storyId, @PathVariable("id") String id, @RequestBody Comment comment) {
	
		return super.save(comment);
	}
	
	@RequestMapping(
			method = RequestMethod.POST, 
			value = "/story/{storyId}/comment", 
			consumes = "application/json", 
			produces = "application/json")
	@ResponseBody
	public Comment create(@PathVariable("storyId") String storyId, @RequestBody Comment comment) {
	
		return super.save(comment);
	}
	
	@RequestMapping(
			method = RequestMethod.DELETE, 
			value = "/story/{storyId}/comment/{id}", 
			consumes = "application/json", 
			produces = "application/json")
	@ResponseBody
	public Boolean delete(@PathVariable("storyId") String storyId, @PathVariable("id") String id) throws Exception {
		
		return super.delete(id);
	}

	@Override
	public CommentRepository getRepository() {
		return repository;
	}

	@Override
	public void setRepository(BaseRepository<Comment> repository) {
		this.repository = (CommentRepository)repository;
	}
}
