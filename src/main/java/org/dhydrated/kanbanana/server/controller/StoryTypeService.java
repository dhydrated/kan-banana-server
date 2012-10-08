package org.dhydrated.kanbanana.server.controller;


import java.util.List;

import org.dhydrated.kanbanana.server.model.StoryType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class StoryTypeService extends BaseService<StoryType> {
	
	@RequestMapping(method = RequestMethod.GET, value = "/project/{projectId}/story_type", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public List<StoryType> get(@PathVariable("projectId") String projectId) {
		
		return super.get(projectId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/project/{projectId}/story_type", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public StoryType save(@PathVariable("projectId") String projectId, @RequestBody StoryType storyType) {
	
		return super.save(storyType);
	}
}
