package org.dhydrated.kanbanana.server.controller;


import java.util.List;

import org.dhydrated.kanbanana.server.model.User;
import org.dhydrated.kanbanana.server.repository.BaseRepository;
import org.dhydrated.kanbanana.server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class UserService extends BaseService<User> {
	

	@Autowired
	private UserRepository repository;
	
	@RequestMapping(method = RequestMethod.GET, value = "/user", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<User> list() {
		
		return super.list(null);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public User get(@PathVariable("id") String id) throws Exception{
		
		return super.get(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user/username/{username}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public User getByUsername(@PathVariable("username") String username) throws Exception{
		
		return getRepository().getByUsername(username);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/user", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public User save(@RequestBody User user) {
	
		return super.save(user);
	}
	

	@Override
	public UserRepository getRepository() {
		return repository;
	}

	@Override
	public void setRepository(BaseRepository<User> repository) {
		this.repository = (UserRepository)repository;
	}
}
