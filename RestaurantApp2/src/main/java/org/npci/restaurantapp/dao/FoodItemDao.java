package org.npci.restaurantapp.dao;

import java.util.List;

import org.npci.restaurantapp.entities.Comment;
import org.npci.restaurantapp.entities.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemDao extends JpaRepository<FoodItem, Long>{
	public List<FoodItem>  findByRestaurantId(Long rId);
}
