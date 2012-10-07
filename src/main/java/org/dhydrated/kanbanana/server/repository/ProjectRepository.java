package org.dhydrated.kanbanana.server.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.dhydrated.kanbanana.server.model.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jappstart.exception.DuplicateUserException;

@Repository
public class ProjectRepository {

	private Logger log = Logger.getLogger(ProjectRepository.class.getName());
	
	@PersistenceContext
	private transient EntityManager entityManager;

    @Transactional
	public Project save(Project project) {

		log.log(Level.FINEST, "Project b4: " + project);
		
		entityManager.persist(project);

		log.log(Level.FINEST, "Project after: " + project);

		return project;
	}

    @Transactional
	public List<Project> list() {

		List<Project> projects = new ArrayList<Project>();

		final Query query = entityManager
				.createQuery("SELECT u FROM Project u");

		projects = query.getResultList();
		if (projects != null && !projects.isEmpty()) {
			throw new DuplicateUserException();
		}

		return projects;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
}
