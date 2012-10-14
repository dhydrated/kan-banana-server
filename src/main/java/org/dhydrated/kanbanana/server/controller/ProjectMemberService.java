package org.dhydrated.kanbanana.server.controller;


import java.util.List;

import org.dhydrated.kanbanana.server.model.ProjectMember;
import org.dhydrated.kanbanana.server.model.ProjectRole;
import org.dhydrated.kanbanana.server.repository.BaseRepository;
import org.dhydrated.kanbanana.server.repository.ProjectMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ProjectMemberService extends BaseService<ProjectMember> {
	

	@Autowired
	private ProjectMemberRepository repository;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/project/{projectId}/user/{userId}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ProjectMember getByProjectId(@PathVariable("projectId") String projectId, @PathVariable("userId") String userId) {

		return getRepository().getByProjectIdAndUserId(projectId, userId);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/project/{projectId}/user/{userId}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public void deleteByProjectIdAndUserId(@PathVariable("projectId") String projectId, @PathVariable("userId") String userId) {

		getRepository().deleteByProjectIdAndUserId(projectId, userId);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/project/{projectId}/user/{userId}", consumes = "application/json", produces = "application/json")
	@ResponseBody
	public ProjectMember getByProjectId(@PathVariable("projectId") String projectId, @PathVariable("userId") String userId, @RequestBody ProjectMember projectMember) {
		
		projectMember.setProjectId(projectId);
		projectMember.setUserId(userId);
		
		if(projectMember.getRole() == null || projectMember.getRole().equals("")){
			projectMember.setRole(ProjectRole.GUEST);
		}
		
		return super.save(projectMember);
	}
	

	@Override
	public ProjectMemberRepository getRepository() {
		return repository;
	}

	@Override
	public void setRepository(BaseRepository<ProjectMember> repository) {
		this.repository = (ProjectMemberRepository)repository;
	}
}
