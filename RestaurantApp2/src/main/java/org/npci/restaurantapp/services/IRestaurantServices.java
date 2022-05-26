package org.npci.restaurantapp.services;

import java.util.List;

import org.npci.restaurantapp.entities.Comment;
import org.npci.restaurantapp.entities.FoodItem;
import org.npci.restaurantapp.entities.Restaurant;

public interface IRestaurantServices {

	Restaurant addR(Restaurant restaurant);
	
	FoodItem addFI(FoodItem foodItem);
	
	String trashFI(Long id);
	
	FoodItem changeFI(FoodItem foodItem);
	
	Comment fb(Comment comment);
	
	List<Comment> sr(Integer id);
	
	List<List<FoodItem>> fil(String street, String city, String state, Integer pin);

}
