package org.dhydrated.kanbanana.server.controller;


import java.util.List;
import java.util.logging.Level;

import org.dhydrated.kanbanana.server.model.Project;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ProjectService extends BaseService<Project> {
	
	@RequestMapping(method = RequestMethod.GET, value = "/project", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<Project> get() {
		
		return super.get(null);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/project", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Project save(@RequestBody Project project) {
	
		return super.save(project);
	}
}
