package com.npci.restaurantapp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;

import com.npci.restaurantapp.entity.Comment;
import com.npci.restaurantapp.entity.FoodItem;
import com.npci.restaurantapp.entity.Restaurant;

public interface IRestaurantServices {


	Restaurant newRestaurant(Restaurant restaurant);

	FoodItem newFoodItem(FoodItem foodItem) ;
	
	String cutoutFoodItem( Integer itemID ) ;

	Comment newComment(Comment comment);

	List<Comment> Comments();
	
	List<Comment> Comments(Integer restID);
	
	Restaurant getByfirstSNameOrCityOrStateOrPincode(String sName,String city,String state, Integer pincode);

	FoodItem updateFood(FoodItem foodItem);
	 	
}
