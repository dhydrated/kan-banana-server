package org.dhydrated.kanbanana.server.repository;

import java.util.List;

import org.dhydrated.kanbanana.server.model.ProjectMember;

public interface ProjectMemberRepository extends BaseRepository<ProjectMember>{

	public List<ProjectMember> getByProjectId(String projectId);
	
	public List<ProjectMember> getByUserId(String userId);

	public ProjectMember getByProjectIdAndUserId(String projectId, String userId);

	public void deleteByProjectIdAndUserId(String projectId, String userId);
}
