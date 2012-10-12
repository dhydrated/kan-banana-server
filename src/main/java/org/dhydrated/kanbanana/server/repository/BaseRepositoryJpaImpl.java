package org.dhydrated.kanbanana.server.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.dhydrated.kanbanana.server.exception.AppException;
import org.springframework.transaction.annotation.Transactional;

public abstract class BaseRepositoryJpaImpl<E> implements BaseRepository<E> {

	private Logger log = Logger.getLogger(BaseRepositoryJpaImpl.class.getName());
	
	@PersistenceContext
	private transient EntityManager entityManager;

	@Override
	@Transactional
	public E save(E entity) {
	
		entityManager.persist(entity);
	
		return entity;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<E> list(String parentId) {
	
		List<E> entities = new ArrayList<E>();
	
		final Query query = entityManager
				.createQuery(this.getAllQuery());
		
		if(parentId != null){
			query.setParameter("parentId", parentId);
		}
	
		entities = query.getResultList();
		/*if (entities != null && !entities.isEmpty()) {
			throw new AppException();
		}*/
	
		return entities;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public abstract String getAllQuery();

	protected abstract Class<E> getEntityClass();
	
	public abstract E createEntity();

	@Override
	public E get(String id) throws Exception {

		EntityManager em = getEntityManager();

		E entity = null;
		try {

			if (id != null) {
				entity = em.find(getEntityClass(), id);
			} else {
				entity = createEntity();
			}
		} catch (Exception e) {
			throw e;
		} finally {
			em.close();
		}

		return entity;
	}
	
	

}
