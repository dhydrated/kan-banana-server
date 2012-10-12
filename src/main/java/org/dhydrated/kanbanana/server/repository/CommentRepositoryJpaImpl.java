package org.dhydrated.kanbanana.server.repository;

import org.dhydrated.kanbanana.server.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepositoryJpaImpl extends BaseRepositoryJpaImpl<Comment> implements CommentRepository {

	@Override
	public String getAllQuery() {
		
		return "SELECT e FROM Comment e WHERE e.storyId=:parentId";
	}

	@Override
	protected Class<Comment> getEntityClass() {
		return Comment.class;
	}

	@Override
	public Comment createEntity() {
		return new Comment();
	}
}
