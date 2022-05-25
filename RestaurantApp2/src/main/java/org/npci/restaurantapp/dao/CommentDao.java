package org.npci.restaurantapp.dao;

import java.util.List;

import org.npci.restaurantapp.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentDao extends JpaRepository<Comment, Long> {

	public List<Comment>  findByRestaurantIdOrderByCommentIdDesc(Integer id);
}
