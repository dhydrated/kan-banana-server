package org.dhydrated.kanbanana.server.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.dhydrated.kanbanana.server.model.ProjectMember;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectMemberRepositoryJpaImpl extends BaseRepositoryJpaImpl<ProjectMember> implements ProjectMemberRepository {

	@Override
	public String getAllQuery() {
		
		return "SELECT e FROM ProjectMember e WHERE e.projectId = :parentId";
	}

	@Override
	protected Class<ProjectMember> getEntityClass() {
		return ProjectMember.class;
	}

	@Override
	public ProjectMember createEntity() {
		return new ProjectMember();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectMember> getByProjectId(String projectId) {
		
		List<ProjectMember> entities = new ArrayList<ProjectMember>();
	
		final Query query = getEntityManager()
				.createQuery("SELECT e FROM ProjectMember e WHERE e.projectId=:projectId");
		
		query.setParameter("projectId", projectId);
	
		entities = query.getResultList();
	
		return entities;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProjectMember> getByUserId(String userId) {
		
		List<ProjectMember> entities = new ArrayList<ProjectMember>();
	
		final Query query = getEntityManager()
				.createQuery("SELECT e FROM ProjectMember e WHERE e.userId=:userId");
		
		query.setParameter("userId", userId);
	
		entities = query.getResultList();
	
		return entities;
	}

	@Override
	public ProjectMember getByProjectIdAndUserId(String projectId, String userId) {
		
		ProjectMember entity = new ProjectMember();
	
		final Query query = getEntityManager()
				.createQuery("SELECT e FROM ProjectMember e WHERE e.userId=:userId AND  e.projectId=:projectId");
		
		query.setParameter("userId", userId);
		query.setParameter("projectId", projectId);
	
		entity = (ProjectMember) query.getSingleResult();
	
		return entity;
	}

	@Override
	public void deleteByProjectIdAndUserId(String projectId, String userId) {
		
		ProjectMember projectMember = getByProjectIdAndUserId(projectId, userId);
		
		getEntityManager().remove(projectMember);
	}
}
