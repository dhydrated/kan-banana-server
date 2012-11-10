package org.dhydrated.kanbanana.server.repository;

import java.util.List;

import org.dhydrated.kanbanana.server.model.Project;
import org.dhydrated.kanbanana.server.model.ProjectMember;

public interface ProjectRepository extends BaseRepository<Project> {


	public List<Project> list(List<ProjectMember> projectMembers) throws Exception;
}
